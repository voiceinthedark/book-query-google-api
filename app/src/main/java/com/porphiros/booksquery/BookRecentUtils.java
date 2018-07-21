package com.porphiros.booksquery;

import android.content.Context;

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
        return book != null && mBooksRecentQueue.offer(book);
    }

    public static boolean saveRecents(Context context) {
        try {
            OutputStream outputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream bookOutStream = new ObjectOutputStream(outputStream);

            for (int i = 0; i < mBooksRecentQueue.size(); i++) {
                bookOutStream.writeObject(mBooksRecentQueue.get(i));
            }
            bookOutStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Book> getRecents(Context context) throws IOException {
        InputStream inputStream = null;
        ObjectInputStream bookInputStream = null;
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


        return new ArrayList<>(mBooksRecentQueue);
    }

    public static int getQueueSize(){
        return mBooksRecentQueue.size();
    }


}
