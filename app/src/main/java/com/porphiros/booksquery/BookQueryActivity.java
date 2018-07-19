package com.porphiros.booksquery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BookQueryActivity extends AppCompatActivity {

    private static final String TAG = BookQueryActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private List<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_query);

        //get a reference to the recycler view
        mRecyclerView = findViewById(R.id.recycler_list);
        //Set the layout manager as a linearLayout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //setup the adapter
        mBookList = BookQueryUtils.getBooksList();
        BooksAdapter booksAdapter = new BooksAdapter(this, mBookList);
        mRecyclerView.setAdapter(booksAdapter);

        for(Book book : mBookList){
            Log.i(TAG,  book.toString());
        }


    }
}
