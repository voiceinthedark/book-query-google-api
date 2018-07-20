package com.porphiros.booksquery;



import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BookQueryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    private static final String TAG = BookQueryActivity.class.getSimpleName();
    private static final int LOADER_ID_WEB_QUERY = 11;
    private static final String GOOGLE_BOOKS_ADDRESS =
            "https://www.googleapis.com/books/v1/volumes?q=a+song+of+ice+and+fire&maxResults=12";

    private RecyclerView mRecyclerView;
    private BooksAdapter mBooksAdapter;

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
        return new BooksAsyncLoader(BookQueryActivity.this, GOOGLE_BOOKS_ADDRESS);
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
}
