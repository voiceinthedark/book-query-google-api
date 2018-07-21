package com.porphiros.booksquery;

import android.content.Context;
import android.util.Log;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Class responsible of handling the control of the Recent Books Activity {@link BookRecentActivity}
 * and writing and reading from mobile storage
 */
public final class BookRecentUtils {

    private static final String TAG = BookRecentUtils.class.getSimpleName();

    /**
     * using {@link org.apache.commons.collections4.queue.CircularFifoQueue} we place a 10 max
     * recent views on the main page
     */
    private static final int MAX_QUEUE = 10;
    private static final String FILENAME = "recent.bin";
    private static CircularFifoQueue<Book> mBooksRecentQueue = new CircularFifoQueue<>(MAX_QUEUE);


    private BookRecentUtils() {
    }

    public static boolean addBookToQueue(Book book) {
        return !mBooksRecentQueue.contains(book) && book != null && mBooksRecentQueue.offer(book);
    }

    public static boolean saveRecents(Context context) {
        Log.i(TAG, "saving file- Queue size: " + BookRecentUtils.getQueueSize());
        try {
            OutputStream outputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream bookOutStream = new ObjectOutputStream(outputStream);

            for (int i = 0; i < mBooksRecentQueue.size(); i++) {
                bookOutStream.writeObject(mBooksRecentQueue.get(i));
            }
            //close the streams
            bookOutStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * methods that query the local file and retrieve saved book objects of the recent viewed list
     *
     * @param context application context
     * @return a {@link List<Book>} objects
     * @throws IOException throws an {@link IOException} if it failed to open the file
     */
    public static List<Book> getRecents(Context context) throws IOException {
        InputStream inputStream = null;
        ObjectInputStream bookInputStream = null;
        //TODO: needs more testing for bugs
        //clear the queue first
        mBooksRecentQueue.clear();
        try {
            inputStream = context.openFileInput(FILENAME);
            if (inputStream != null) {
                bookInputStream = new ObjectInputStream(inputStream);
                while (true) {
                    try {
                        Book book = (Book) bookInputStream.readObject();
                        mBooksRecentQueue.offer(book);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (EOFException ex) {
            //end of file
            inputStream.close();

            if (bookInputStream != null) {
                bookInputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "loading file - Queue size: " + BookRecentUtils.getQueueSize());

        return new ArrayList<>(mBooksRecentQueue);
    }

    /**
     * helper methods for debuging
     *
     * @return size of the circular fixed queue {@link CircularFifoQueue}
     */
    public static int getQueueSize() {
        return mBooksRecentQueue.size();
    }


}
