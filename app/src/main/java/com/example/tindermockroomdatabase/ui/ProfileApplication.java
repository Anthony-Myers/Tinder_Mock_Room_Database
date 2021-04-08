package com.example.tindermockroomdatabase.ui;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileApplication extends Application {
    public static ProfileApplication INSTANCE;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(4);

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public ExecutorService getExecutorService(){return mExecutorService;}
}
