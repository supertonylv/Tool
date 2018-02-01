package com.example.tony.tool;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by tony on 2017/8/8.
 */

public class MyApplication extends Application {

    RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        setupLeakCanary();
    }


    protected RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return null;
        }
        return LeakCanary.install(this);
    }

    public void  watch(Object object){
        if(refWatcher != null) {
            refWatcher.watch(object);
        }
    }
}
