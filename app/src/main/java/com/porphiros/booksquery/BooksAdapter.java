package com.porphiros.booksquery;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {

    private List<Book> mBooks;

    public BooksAdapter(List<Book> books) {
        mBooks = books;
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

    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {

        private TextView mTitle_Tv;

        public BookHolder(View itemView) {
            super(itemView);
            mTitle_Tv = itemView.findViewById(R.id.row_book_title);
        }
    }


}
