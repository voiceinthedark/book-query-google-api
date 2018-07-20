package com.porphiros.booksquery;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {

    private static final String TAG = BooksAdapter.class.getSimpleName();

    private List<Book> mBooks;
    private Context mContext;

    public BooksAdapter(Context context, List<Book> books) {
        mBooks = books;
        mContext = context;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_row, parent, false);


        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.mTitle_Tv.setText(book.getTitle());
        holder.mRatingBar.setRating((float) book.getRating());
        //set the image with Glide library

        //to setup placeholders
        RequestOptions requestOptions = new RequestOptions();
        //In case there is no image loaded from the web api
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);

        GlideApp.with(holder.mThumbnail.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(Uri.parse(book.getThumbnailSmall()))
                .into(holder.mThumbnail);
        Log.i(TAG, "book thumbnail: " + book.getThumbnailSmall());


        holder.mSubtitle.setText(book.getSubtitle());

    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    /**
     * helper method to be called once {@link android.content.AsyncTaskLoader} is finished loading
     *
     * @param data the data received from the background loader
     */
    public void updateAdapterData(List<Book> data) {
        mBooks = data;
        notifyDataSetChanged();
    }

    public class BookHolder extends RecyclerView.ViewHolder {

        private TextView mTitle_Tv;
        private AppCompatRatingBar mRatingBar;
        private ImageView mThumbnail;
        private TextView mSubtitle;

        public BookHolder(View itemView) {
            super(itemView);
            mTitle_Tv = itemView.findViewById(R.id.row_book_title);
            mRatingBar = itemView.findViewById(R.id.row_book_rating);
            mThumbnail = itemView.findViewById(R.id.row_book_img);
            mSubtitle = itemView.findViewById(R.id.row_book_subtitle);
        }
    }


}
