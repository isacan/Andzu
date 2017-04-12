package com.canakkoca.andzu.network;

import android.util.Log;

import com.canakkoca.andzu.base.AndzuApp;
import com.canakkoca.andzu.network.models.NetworkLog;
import com.canakkoca.andzu.network.models.NetworkLogDao;

import java.io.IOException;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by can.akkoca on 4/11/2017.
 */

public class LoggingInterceptor implements Interceptor {

    private AndzuApp app;
    private NetworkLogDao networkLogDao;

    public LoggingInterceptor(AndzuApp app){
        this.app = app;
        networkLogDao = app.getDaoSession().getNetworkLogDao();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();


        long t1 = System.nanoTime();
        Log.d("Andzu",String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);


        long t2 = System.nanoTime();
        Log.d("Andzu",String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        NetworkLog networkLog = new NetworkLog();
        networkLog.setDate(new Date().getTime());
        networkLog.setDuration((t2 - t1) / 1e6d);
        networkLog.setErrorClientDesc("");
        networkLog.setHeaders("");
        networkLog.setRequestType(request.method());
        networkLog.setResponseCode(String.valueOf(response.code()));
        networkLog.setResponseData(response.body().string());
        networkLog.setUrl(String.valueOf(request.url()));

        networkLogDao.insert(networkLog);

        return response;
    }
}
