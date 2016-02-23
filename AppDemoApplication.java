package com.example.fairlynguyen.demoproject;

import android.app.Application;

/**
 * Created by fairlyNGUYEN on 2/23/2016.
 */
public class AppDemoApplication extends Application {
    private BaseAppObserver mBaseAppObserver;

    public static AppDemoApplication getInstance() {
        return mInstance;
    }

    private static AppDemoApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mBaseAppObserver = new BaseAppObserver();
    }

    public BaseAppObserver getObserver() {
        return mBaseAppObserver;
    }
}
