package com.canakkoca.sample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.canakkoca.andzu.base.AndzuActivity;
import com.canakkoca.andzu.base.AndzuApp;
import com.canakkoca.andzu.utils.Logger;
import com.canakkoca.andzu.utils.LoggingInterceptor;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AndzuActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAndzu();

        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("message", "Your message")
                .build();

        final Request request = new Request.Builder()
                .url("http://www.vogella.com/index.html")
                .build();


        new AsyncTask<Void,Integer,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Response response = client.newCall(request).execute();
                    Log.d("","");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute();

        Logger.inf("info");

        Logger.err("error",Logger.HI_PRI);

        Logger.d("debug");

        Logger.v("verbose",Logger.LOW_PRI);

        Logger.w("warn");

    }
}
