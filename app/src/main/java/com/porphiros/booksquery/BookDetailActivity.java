package com.porphiros.booksquery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookDetailActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK = "com.porphiros.book";

    private TextView mTitle;
    private TextView mSubTitle;
    private TextView mAuthors;
    private TextView mPublisher;
    private TextView mPublishDate;
    private ImageView mImage;

    private Book mBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        //setup views
        mTitle = findViewById(R.id.detail_title);
        mSubTitle = findViewById(R.id.detail_subtitle);
        mAuthors = findViewById(R.id.detail_authors);
        mPublisher = findViewById(R.id.detail_publisher);
        mPublishDate = findViewById(R.id.detail_date);
        mImage = findViewById(R.id.detail_image);

        //get teh book object from intent
        mBook = (Book) getIntent().getSerializableExtra(EXTRA_BOOK);

        mTitle.setText(mBook.getTitle());
        mSubTitle.setText(mBook.getSubtitle());

        List<String> authors = mBook.getAuthors();
        String authorConcat = "";
        for(String a : authors){
            authorConcat += a + ", ";
        }
        //if string of authors not empty
        if(authorConcat.length() > 2){
            authorConcat = authorConcat.substring(0, authorConcat.length() - 2);
        }
        mAuthors.setText(authorConcat);

        mPublisher.setText(mBook.getPublisher());
        mPublishDate.setText(mBook.getPublishedDate());

        GlideApp.with(this)
                .load(Uri.parse(mBook.getThumbnailSmall()))
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(mImage);

        //set the title of the activity as the book name
        setTitle(mBook.getTitle());


    }

    public static Intent newIntent(Context context, Book book){
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        return intent;
    }


}
