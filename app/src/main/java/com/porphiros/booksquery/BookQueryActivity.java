package com.porphiros.booksquery;


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
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class BookQueryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    private static final String TAG = BookQueryActivity.class.getSimpleName();
    private static final int LOADER_ID_WEB_QUERY = 11;
    private static final String GOOGLE_BOOKS_ADDRESS =
            "https://www.googleapis.com/books/v1/volumes?q=a+song+of+ice+and+fire&maxResults=12";

    private RecyclerView mRecyclerView;
    private BooksAdapter mBooksAdapter;
    //default empty query
    private String mQuery = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_query);

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

        //setup the loader
        getSupportLoaderManager().initLoader(LOADER_ID_WEB_QUERY, null, this);
    }


    @NonNull
    @Override
    public android.support.v4.content.Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        //return a new instance of our custom loader with the query (empty)
        return new BooksAsyncLoader(BookQueryActivity.this, mQuery);
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<List<Book>> loader, List<Book> data) {
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
                //set the query to the user submission after encoding it
                mQuery = BookQueryUtils.encodeUrl(query);
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
}
