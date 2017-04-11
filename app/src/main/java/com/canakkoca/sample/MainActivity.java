package com.canakkoca.sample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.canakkoca.andzu.base.AndzuActivity;
import com.canakkoca.andzu.network.LoggingInterceptor;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AndzuActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAndzu();


        LoggingInterceptor interceptor = new LoggingInterceptor();

        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
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

    }
}
