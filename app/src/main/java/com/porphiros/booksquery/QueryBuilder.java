package com.porphiros.booksquery;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Helper class to fix memory leaks while building the Query url
 */
public final class QueryBuilder {
    private static final String QUERY_HOME = "https://www.googleapis.com/books/v1/volumes?q=";
    private static final String FIELD_MAX_RESULT = "&maxResults=";
    /*according to Google Book api max is 40*/
    private static final int MAX_RESULT = 40;
    //Google order by
    private static final String FIELD_ORDER = "&orderBy=";
    private static final String FIELD_KEY = "&key=";

    //the api key from config
    private final String mApiKey;

    private Context mContext;

    public QueryBuilder(Context context){
        mContext = context;
        mApiKey = BuildConfig.ApiKey;
    }

    public QueryBuilder(Context context, String apiKey){
        mContext = context;
        mApiKey = apiKey;
    }


    /**
     * Helper method to encode a URL into valid format using java's {@link URLEncoder}
     * @param queryParameters the user's search input
     * @return a valid and well formed {@link URL} string
     */
    public String encodeUrl(String queryParameters) {
        StringBuilder builder = new StringBuilder();

        //bind query parameters from the shared preferences

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(mContext);
        String limit = sharedPreferences.getString(mContext.getString(R.string.settings_limit_key),
                mContext.getString(R.string.settings_limit_default));

        String order = sharedPreferences.getString(mContext.getString(R.string.settings_order_key),
                mContext.getString(R.string.settings_order_default));

        builder.append(QUERY_HOME);
        try {
            //encode the query parameters
            String encodedQuery = URLEncoder.encode(queryParameters, "UTF-8");
            builder.append(encodedQuery);
            builder.append(FIELD_MAX_RESULT);
            builder.append(limit); //40 max
            builder.append(FIELD_ORDER);
            builder.append(order);

            if(mApiKey != null && !mApiKey.equals("")){
                builder.append(FIELD_KEY);
                builder.append(mApiKey);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
