package com.porphiros.booksquery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class responsible of showing recent activity
 */
public class BookRecentActivity extends AppCompatActivity {

    private BooksRecentAdapter mBooksRecentAdapter;
    private RecyclerView mCardRecycler;

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

    }
}
