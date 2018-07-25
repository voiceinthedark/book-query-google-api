
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
