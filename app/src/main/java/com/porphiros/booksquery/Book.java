package com.porphiros.booksquery;

import java.util.Collections;
import java.util.List;

/**
 * Class {@link Book} to hold information needed about books fetched from Google Book web API
 */
public class Book {
    //field title book
    private String mTitle;
    //book subtitle, could be null
    private String mSubtitle;
    //field authors
    private List<String> mAuthors;
    //google book id
    private String mGoogleID;
    //book publisher
    private String mPublisher;
    //published date
    private String mPublishedDate;
    //Book description
    private String mDescription;
    //ISBN-13
    private String mISBN;
    //page count
    private int mPageCount;
    //Book categories
    private List<String> mCategories;
    //Book thumbnail
    private String mThumbnailSmall;
    //Book link
    private String mPreviewLink;
    //Book language
    private String mLanguage;
    //Book rating
    private double mRating;

    /**
     * private class to associate the Book fields from the builder set fields
     * @param builder the builder object of our inner class
     */
    private Book(Builder builder){
        mTitle = builder.mTitle;
        mSubtitle = builder.mSubtitle;
        mAuthors = builder.mAuthors;
        mGoogleID = builder.mGoogleID;
        mPublisher = builder.mPublisher;
        mPublishedDate = builder.mPublishedDate;
        mDescription = builder.mDescription;
        mISBN = builder.mISBN;
        mPageCount = builder.mPageCount;
        mCategories = builder.mCategories;
        mThumbnailSmall = builder.mThumbnailSmall;
        mPreviewLink = builder.mPreviewLink;
        mLanguage = builder.mLanguage;
        mRating = builder.mRating;
    }

    public static class Builder{ /*Start of inner builder class*/
        /*required fields*/
        //field title book
        private final String mTitle;
        //Book description
        private final String mDescription;

        /*Optional fields*/
        //book subtitle, could be null
        private String mSubtitle = "";
        //field authors
        private List<String> mAuthors = Collections.EMPTY_LIST;
        //google book id
        private String mGoogleID = "1";
        //book publisher
        private String mPublisher = "generic house";
        //published date
        private String mPublishedDate = "1800";
        //ISBN-13
        private String mISBN = "11111111111";
        //page count
        private int mPageCount = 0;
        //Book categories
        private List<String> mCategories = Collections.EMPTY_LIST;
        //Book thumbnail
        private String mThumbnailSmall = "";
        //Book link
        private String mPreviewLink = "";
        //Book language
        private String mLanguage = "en";
        //Book rating
        private double mRating = 0.0;

        /**
         * Required fields of the builder, the title and the description
         * @param title of the book
         * @param description of the book
         */
        public Builder(String title, String description) {
            mTitle = title;
            mDescription = description;
        }

        /**
         * set the subtitle of the book
         * @param subtitle the subtitle of the book
         * @return reference to this builder
         */
        public Builder subtitle(String subtitle){
            this.mSubtitle = subtitle;
            return this;
        }

        public Builder authors(List<String> authors){
            this.mAuthors = authors;
            return this;
        }

        public Builder googleId(String googleID){
            this.mGoogleID = googleID;
            return this;
        }

        public Builder publisher(String publisher){
            this.mPublisher = publisher;
            return this;
        }

        public Builder publishedOn(String date){
            this.mPublishedDate = date;
            return this;
        }

        public Builder isbn(String isbn){
            this.mISBN = isbn;
            return this;
        }

        public Builder pages(int pages){
            mPageCount = pages;
            return this;
        }

        public Builder categories(List<String> categories){
            mCategories = categories;
            return this;
        }

        public Builder thumbnail(String thumbnailSmall){
            mThumbnailSmall = thumbnailSmall;
            return this;
        }

        public Builder url(String url){
            mPreviewLink = url;
            return this;
        }

        public Builder language(String language){
            mLanguage = language;
            return this;
        }

        public Builder rating(double rating){
            mRating = rating;
            return this;
        }

        public Book build(){
            return new Book(this);
        }

    } /*end of inner builder class*/

    /**
     *
     * @return title of the book
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     *
     * @return subtitle of the book
     */
    public String getSubtitle() {
        return mSubtitle;
    }

    /**
     *
     * @return a list containing the author(s) of the book
     */
    public List<String> getAuthors() {
        return mAuthors;
    }

    /**
     *
     * @return the google id associated with the book
     */
    public String getGoogleID() {
        return mGoogleID;
    }

    /**
     *
     * @return the publisher of the book
     */
    public String getPublisher() {
        return mPublisher;
    }

    /**
     *
     * @return the date on which teh book was published
     */
    public String getPublishedDate() {
        return mPublishedDate;
    }

    /**
     *
     * @return a description of the book
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     *
     * @return the ISBN-13 of the book
     */
    public String getISBN() {
        return mISBN;
    }

    /**
     *
     * @return the pages count of the book
     */
    public int getPageCount() {
        return mPageCount;
    }

    /**
     *
     * @return the category the book is associated with
     */
    public List<String> getCategories() {
        return mCategories;
    }

    /**
     *
     * @return the url of the thumbnail picture of the book cover
     */
    public String getThumbnailSmall() {
        return mThumbnailSmall;
    }

    /**
     *
     * @return a google preview link, could be a sample or full text
     */
    public String getPreviewLink() {
        return mPreviewLink;
    }

    /**
     *
     * @return the language the book is written in
     */
    public String getLanguage() {
        return mLanguage;
    }

    public double getRating() {
        return mRating;
    }

    @Override
    public String toString() {
        return "Book{" + "\n" +
                "mTitle='" + mTitle + '\'' + "\n" +
                ", mSubtitle='" + mSubtitle + '\'' + "\n" +
                ", mAuthors=" + mAuthors + "\n" +
                ", mGoogleID='" + mGoogleID + '\'' + "\n" +
                ", mPublisher='" + mPublisher + '\'' + "\n" +
                ", mPublishedDate='" + mPublishedDate + '\'' + "\n" +
                ", mDescription='" + mDescription + '\'' + "\n" +
                ", mISBN='" + mISBN + '\'' + "\n" +
                ", mPageCount=" + mPageCount + "\n" +
                ", mCategories=" + mCategories + "\n" +
                ", mThumbnailSmall='" + mThumbnailSmall + '\'' + "\n" +
                ", mPreviewLink='" + mPreviewLink + '\'' + "\n" +
                ", mLanguage='" + mLanguage + '\'' + "\n" +
                ", mRating=" + mRating + "\n" +
                '}';
    }
}
