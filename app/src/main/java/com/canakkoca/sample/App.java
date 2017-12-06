package com.canakkoca.sample;

import com.canakkoca.andzu.base.AndzuApp;

/**
 * Created by can.akkoca on 4/12/2017.
 */

public class App extends AndzuApp {

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    private static App sInstance;

    public static App getInstance() {
        return sInstance;
    }
}
