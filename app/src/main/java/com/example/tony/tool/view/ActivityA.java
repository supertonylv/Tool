package com.example.tony.tool.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.tony.tool.R;
import com.example.tony.tool.aidl.Book;
import com.example.tony.tool.aidl.IBookManagerInterface;
import com.example.tony.tool.modle.service.BookManagerService;

import java.util.List;

/**
 * Created by tony on 2017/8/11.
 */

public class ActivityA extends AppCompatActivity {

    private static String TAG = "ActivityA";

    TextView textView;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManagerInterface bookManagerInterface = IBookManagerInterface.Stub.asInterface(service);
            try {
                List<Book> books = bookManagerInterface.getBooks();
                Log.i(TAG,"books :"+ books.getClass().getCanonicalName());
                Log.i(TAG,"books :"+ books.toString());
                bookManagerInterface.addBook(new Book(3,"javascript"));
                List<Book> books1 = bookManagerInterface.getBooks();
                Log.i(TAG,"books1 :"+ books1.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }


}
