package com.porphiros.booksquery;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class BookQueryUtils {

    private static final String TAG = "bookquery";

    private BookQueryUtils() {
    }

    /**
     * main method of the {@link BookQueryUtils} class, that will extract a {@link Book} objects
     * {@link List}
     * @param webAddress the webAddress to be queried
     * @return a {@link List} of {@link Book} objects
     */
    public static List<Book> getBooksList(String webAddress){
        return extractBooksFromJSON(webAddress);
    }

    /**
     * helper method to parse the JSON response received
     * @param webAddress the JSON response
     * @return List<Book> a list of books
     */
    private static List<Book> extractBooksFromJSON(String webAddress){
        //setup an empty book list
        List<Book> bookList = new ArrayList<>();
        //if response was empty return an empty booklist
        if(TextUtils.isEmpty(webAddress)){
            return bookList;
        }

        //Create a url from the webAdress String
        URL url = createURL(webAddress);

        //retrieve a Json string from the url connection
        String jsonString = makeHttpConnection(url);

        //if the jsonString was empty return empty booklist
        if(TextUtils.isEmpty(jsonString)){
            return bookList;
        }


        //else try to parse the Json String
        try {
            //set The JSON object root
            JSONObject root = new JSONObject(jsonString);
            //find the items array
            JSONArray itemsArray = root.getJSONArray("items");
            //loop over the array items
            for (int i = 0; i < itemsArray.length(); i++) {
                //get the object at location i
                JSONObject item = itemsArray.getJSONObject(i);
                //get the googleid
                String googleId = item.optString("id", "");

                Log.i(TAG, "googleid: " + googleId);

                //get the object called volume info
                JSONObject volumeInfo = item.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                //get subtitle
                String subtitle = volumeInfo.optString("subtitle", "");
                //get authors array
                List<String> authors = new ArrayList<>();
                JSONArray authorsArray = volumeInfo.optJSONArray("authors");
                for (int j = 0; j < authorsArray.length(); j++) {
                    String author = authorsArray.optString(j);
                    authors.add(author);

                    Log.i(TAG, "author: " + author);
                }
                //get publisher
                String publisher = volumeInfo.optString("publisher", "");
                //get publishing date
                String date = volumeInfo.optString("publishedDate", "");
                //get description
                String description = volumeInfo.getString("description");
                //get ISBN array
                JSONArray isbnArray = volumeInfo.getJSONArray("industryIdentifiers");
                JSONObject isbnObj = isbnArray.getJSONObject(0);
                String isbn = isbnObj.optString("identifier", "1111");
                //get pageCount
                int pages = volumeInfo.optInt("pageCount", 0);
                //get categories array
                JSONArray categoriesArray = volumeInfo.getJSONArray("categories");
                List<String> categories = new ArrayList<>();
                for (int j = 0; j < categoriesArray.length(); j++) {
                    String category = categoriesArray.optString(j);
                    categories.add(category);

                    Log.i(TAG, "category: " + category);
                }
                //get averageRating
                double rating = volumeInfo.optDouble("averageRating", 0.0);
                //get imageLinks object , get thumbnail string
                JSONObject imagesObject = volumeInfo.getJSONObject("imageLinks");
                String imgUrl = imagesObject.optString("smallThumbnail", "");
                //get language
                String language = volumeInfo.optString("language", "en");
                //get previewLink
                String previewLink = volumeInfo.optString("previewLink", "");

                //Add the data to the book object
                Book book = new Book.Builder(title, description)
                        .googleId(googleId)
                        .isbn(isbn)
                        .subtitle(subtitle)
                        .publishedOn(date)
                        .rating(rating)
                        .thumbnail(imgUrl)
                        .language(language)
                        .publisher(publisher)
                        .pages(pages)
                        .url(previewLink)
                        .authors(authors)
                        .categories(categories).build();
                //add the book to the list
                bookList.add(book);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    /**
     * helper method tho create a URL from a string
     * @param response the response received from the Google book API
     * @return a formatted URL
     */
    @Nullable
    private static URL createURL(String response)  {
        if(TextUtils.isEmpty(response)){
            return null;
        }
        URL url = null;
        try {
            url = new URL(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * Make an {@link HttpURLConnection} to the url received from the createURL method and receive an
     * {@link InputStream} containing the binary data of our response
     * @param url the {@link URL} object containing the web API address
     * @return a formatted String of JSON
     */
    private static String makeHttpConnection(URL url){
        if(url == null){
            return "";
        }
        HttpURLConnection urlConnection= null;
        InputStream inputStream = null;
        String parsedResponse = "";

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.connect();
            //if connection successful
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = urlConnection.getInputStream();
                parsedResponse = createJSONFromStream(inputStream);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return parsedResponse;
    }

    /**
     * method will accept an input stream from the http url connection and transform the binary input into
     * string of JSON data
     * @param inputStream the input stream received when {@link HttpURLConnection} connected to the URL
     * @return a string containing the JSON response
     * @throws IOException if connection get lost
     */
    private static String createJSONFromStream(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;

        try {
            streamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(streamReader);

            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(streamReader != null){
                streamReader.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
        return stringBuilder.toString();
    }




}
