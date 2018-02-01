package com.example.tony.tool.modle.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.tony.tool.aidl.Book;
import com.example.tony.tool.aidl.IBookManagerInterface;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookManagerService extends Service {

    private static String TAG = "BookManagerService";

    CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();

    private IBinder mBinder = new IBookManagerInterface.Stub(){
        @Override
        public List<Book> getBooks() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };

    public BookManagerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1,"Android"));
        mBookList.add(new Book(2,"IOS"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
