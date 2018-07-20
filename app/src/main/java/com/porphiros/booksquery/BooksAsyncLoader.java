package com.porphiros.booksquery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class BooksAsyncLoader extends AsyncTaskLoader<List<Book>> {

    private String mWebAddress;

    /**
     * Default Constructor for our custom {@link AsyncTaskLoader}
     * @param context application context
     * @param webAddress the web address of the google books web api query
     */
    public BooksAsyncLoader(@NonNull Context context, String webAddress) {
        super(context);
        mWebAddress = webAddress;
    }

    /**
     * The main Asynchronous work of loading data will happen in this method on the background
     * thread
     * @return a {@link List} of {@link Book}
     */
    @Nullable
    @Override
    public List<Book> loadInBackground() {
        return BookQueryUtils.getBooksList(mWebAddress);
    }

    @Override
    protected void onStartLoading() {
        //force loading on start
        forceLoad();
    }
}
