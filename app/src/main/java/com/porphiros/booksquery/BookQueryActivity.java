
/*
 *   Copyright 2018 Firas Abbas (Kairos Sin)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.porphiros.booksquery;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookQueryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    private static final String TAG = BookQueryActivity.class.getSimpleName();
    private static final int LOADER_ID_WEB_QUERY = 11;
    private static final String GOOGLE_BOOKS_ADDRESS =
            "https://www.googleapis.com/books/v1/volumes?q=a+song+of+ice+and+fire&maxResults=12";
    //setup Id of the intent extra
    private static final String EXTRA_QUERY = "com.porphiros.query";

    private RecyclerView mRecyclerView;
    private BooksAdapter mBooksAdapter;
    //default empty query
    private String mQuery = "";
    private ProgressBar mProgressBar;
    private TextView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_query);

        /**
         * receive the query from the {@link BookRecentActivity} intent
         */
        mQuery = getIntent().getStringExtra(EXTRA_QUERY);
        //if the query string not empty, start the loader
        if(!TextUtils.isEmpty(mQuery)){
            getSupportLoaderManager()
                    .initLoader(LOADER_ID_WEB_QUERY,
                            null,
                            BookQueryActivity.this);
        }

        //setup the empty view
        mEmptyView = findViewById(R.id.empty_view);
        mEmptyView.setVisibility(View.GONE);

        //setup the progress bar
        mProgressBar = findViewById(R.id.query_progress_bar);
        mProgressBar.setIndeterminate(true);

        //get a reference to the recycler view
        mRecyclerView = findViewById(R.id.recycler_list);
        //Set the layout manager as a linearLayout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        //setup an empty adapter
        mBooksAdapter = new BooksAdapter(this, new ArrayList<Book>());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //attach the adapter to the recyclerview
        mRecyclerView.setAdapter(mBooksAdapter);
        mRecyclerView.setVisibility(View.GONE);

/**
 * Check whether there is internet connection
 */
        //Get the connectivity manager
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        //get the NetworkInfo from the connectivity manager
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        //if there is a connection then start loading data, make sure that the null check
        //comes before the boolean check, otherwise the app will crash with null pointer exception
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
        /*
          Get the support load manager and initialize the loader.
          the initLoader takes three arguments an id; a {@link Bundle} argument
          and a {@link android.support.v4.app.LoaderManager.LoaderCallbacks}
         */
            getSupportLoaderManager().initLoader(LOADER_ID_WEB_QUERY, null, this);
        } else {
            mEmptyView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);

        }
    }


    @NonNull
    @Override
    public android.support.v4.content.Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        //return a new instance of our custom loader with the query (empty)
        return new BooksAsyncLoader(BookQueryActivity.this, mQuery);
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<List<Book>> loader, List<Book> data) {
        //when loading data is done, hide progress indicator and show the recycler view
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        //Update UI by updating the recyler view adapter with the new data
        mBooksAdapter.updateAdapterData(data);
    }

    @Override
    public void onLoaderReset(@NonNull android.support.v4.content.Loader<List<Book>> loader) {
        //setup with empty adapter
        mBooksAdapter = new BooksAdapter(this, new ArrayList<Book>());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu from our xml file
        getMenuInflater().inflate(R.menu.menu_search, menu);

        //get reference to the action search
        MenuItem menuItem = menu.findItem(R.id.action_search);

        //get our searchview that we set up as a menu item in the menu layout
        final SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //when the user queries data hide the recycler view and show a progress indicator
                mProgressBar.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);

                //set the query to the user submission after encoding it
                QueryBuilder queryBuilder = new QueryBuilder(BookQueryActivity.this);
                mQuery = queryBuilder.encodeUrl(query);

                //restart the loader to make sure the data gets loaded from the web api
                getSupportLoaderManager()
                        .restartLoader(LOADER_ID_WEB_QUERY,
                                null,
                                BookQueryActivity.this);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent settingsIntent = new Intent(
                        BookQueryActivity.this, BookSettingsActivity.class);
                startActivity(settingsIntent);
                return true;
        }
        return false;
    }

    /**
     * explicit intent sent from {@link BookRecentActivity}
     * @param context the {@link BookRecentActivity} context
     * @param query the query search
     * @return an Intent back to {@link BookRecentActivity}
     */
    public static Intent newIntent(Context context, String query){
        Intent intent = new Intent(context, BookQueryActivity.class);
        intent.putExtra(EXTRA_QUERY, query);
        return intent;
    }
}
