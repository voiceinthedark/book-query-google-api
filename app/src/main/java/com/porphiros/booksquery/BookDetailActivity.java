package com.porphiros.booksquery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookDetailActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK = "com.porphiros.book";
    private static final String TAG = BookDetailActivity.class.getSimpleName();

    private TextView mTitle;
    private TextView mSubTitle;
    private TextView mAuthors;
    private TextView mPublisher;
    private TextView mPublishDate;
    private ImageView mImage;
    private TextView mDescription;
    private Button mPreviewSample;
    private TextView mPages;
    private TextView mIsbn;
    private TextView mCategories;

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
        mDescription = findViewById(R.id.detail_description);
        mPreviewSample = findViewById(R.id.detail_preview);
        mPages = findViewById(R.id.detail_pages);
        mIsbn = findViewById(R.id.detail_isbn);
        mCategories = findViewById(R.id.detail_category);

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

        //set description
        mDescription.setText(mBook.getDescription());

        //make the preview sample button redirect to Google Books page
        mPreviewSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mBook.getPreviewLink()));
                startActivity(intent);
            }
        });

        //set the pages
        mPages.setText(String.valueOf(mBook.getPageCount()));
        mIsbn.setText(mBook.getISBN());

        //Setup the categories
        List<String> categoriesList = mBook.getCategories();
        String categories = "";
        for(String category : categoriesList){
            categories += category + ", ";
        }
        if(categories.length() >= 2){
            categories = categories.substring(0, categories.length() - 2);
        }
        mCategories.setText(categories);

        //set the title of the activity as the book name
        setTitle(mBook.getTitle());


    }

    public static Intent newIntent(Context context, Book book){
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        return intent;
    }

    /**
     * save recent books list when this activity loses focus or get destroyed
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "saving recents book to file");
        BookRecentUtils.saveRecents(this);
    }
}
