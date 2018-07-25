
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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class responsible of showing recent activity
 */
public class BookRecentActivity extends AppCompatActivity {

    private BooksRecentAdapter mBooksRecentAdapter;
    private RecyclerView mCardRecycler;

    private String mQuery = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_recent);

        //setup a grid recyclerview
        mCardRecycler = findViewById(R.id.recent_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mCardRecycler.setLayoutManager(layoutManager);
        mCardRecycler.setItemAnimator( new DefaultItemAnimator());

        try {
            mBooksRecentAdapter =
                    new BooksRecentAdapter(this,
                            BookRecentUtils.getRecents(this));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mCardRecycler.setAdapter(mBooksRecentAdapter);

        //set the activity title
        setTitle(R.string.recent_activity_title);


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
                QueryBuilder queryBuilder = new QueryBuilder(BookRecentActivity.this);
                mQuery = queryBuilder.encodeUrl(query);
                //start intent to query
                Intent intent = BookQueryActivity
                        .newIntent(BookRecentActivity.this, mQuery);
                startActivity(intent);

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
                        BookRecentActivity.this, BookSettingsActivity.class);
                startActivity(settingsIntent);
                return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            mBooksRecentAdapter =
                    new BooksRecentAdapter(this,
                            BookRecentUtils.getRecents(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
