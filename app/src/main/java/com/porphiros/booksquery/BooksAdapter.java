package com.porphiros.booksquery;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {

    public  class BookHolder extends RecyclerView.ViewHolder{

        public BookHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
