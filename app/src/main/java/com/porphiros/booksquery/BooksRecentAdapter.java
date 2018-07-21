package com.porphiros.booksquery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BooksRecentAdapter extends RecyclerView.Adapter<BooksRecentAdapter.BookRecentHolder> {

    private List<Book> mRecentBooks;
    private Context mContext;


    public class BookRecentHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //get reference to the cardview
        private CardView mCardView;

        private ImageView mBookCardImage;
        private TextView mBookCardTitle;

        public BookRecentHolder(View itemView) {
            super(itemView);

            mBookCardImage = itemView.findViewById(R.id.card_thumbnail);
            mBookCardTitle = itemView.findViewById(R.id.card_title);
            mCardView = itemView.findViewById(R.id.book_recent_card);

            //set the click listener on the card
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //get the book from recent view list
            Book book = mRecentBooks.get(this.getAdapterPosition());
            //start intent
            Intent intent = BookDetailActivity.newIntent(mContext, book);
            mContext.startActivity(intent);

        }
    }

    public BooksRecentAdapter(Context context, List<Book> recentBooks){
        this.mContext = context;
        this.mRecentBooks = recentBooks;
    }

    @NonNull
    @Override
    public BookRecentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_card, parent, false);

        return new BookRecentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookRecentHolder holder, int position) {
        Book book = mRecentBooks.get(position);
        holder.mBookCardTitle.setText(book.getTitle());
        GlideApp.with(mContext)
                .load(Uri.parse(book.getThumbnailSmall()))
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(holder.mBookCardImage);

    }

    @Override
    public int getItemCount() {
        return mRecentBooks.size();
    }




}
