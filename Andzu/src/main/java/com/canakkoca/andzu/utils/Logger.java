package com.canakkoca.andzu.utils;

import android.app.Application;
import android.util.Log;

import com.canakkoca.andzu.base.AndzuApp;
import com.canakkoca.andzu.base.AppLog;
import com.canakkoca.andzu.base.AppLogDao;
import com.canakkoca.andzu.base.DaoSession;

import java.util.Date;

/**
 * Created by can.akkoca on 4/18/2017.
 */

public class Logger {

    public static String LOW_PRI = "LOW";
    public static String MED_PRI = "MEDIUM";
    public static String HI_PRI = "HIGH";

    private static DaoSession daoSession;
    private static AppLogDao appLogDao;

    private static final String TAG = "Logger";

    public static void init(Application application) {
        daoSession = ((AndzuApp)application).getDaoSession();
        appLogDao = daoSession.getAppLogDao();
    }

    public static void inf(String msg,String priority) {
        Log.i(TAG,msg);
        AppLog appLog = new AppLog();
        appLog.setCreated_at(new Date().getTime());
        appLog.setTag(TAG);
        appLog.setPriority(priority);
        appLog.setMessage(msg);
        appLog.setLog_type("INFO");
        appLogDao.insert(appLog);
    }

    public static void inf(String msg) {
        inf(msg,MED_PRI);
    }

    public static void err(String msg,String priority) {
        Log.e(TAG,msg);
        AppLog appLog = new AppLog();
        appLog.setCreated_at(new Date().getTime());
        appLog.setTag(TAG);
        appLog.setPriority(priority);
        appLog.setMessage(msg);
        appLog.setLog_type("ERROR");
        appLogDao.insert(appLog);
    }

    public static void err(String msg) {
        err(msg,MED_PRI);
    }

    public static void d(String msg,String priority) {
        Log.d(TAG,msg);
        AppLog appLog = new AppLog();
        appLog.setCreated_at(new Date().getTime());
        appLog.setTag(TAG);
        appLog.setPriority(priority);
        appLog.setMessage(msg);
        appLog.setLog_type("DEBUG");
        appLogDao.insert(appLog);
    }

    public static void d(String msg) {
        d(msg,MED_PRI);
    }

    public static void v(String msg,String priority) {
        Log.v(TAG,msg);
        AppLog appLog = new AppLog();
        appLog.setCreated_at(new Date().getTime());
        appLog.setTag(TAG);
        appLog.setPriority(priority);
        appLog.setMessage(msg);
        appLog.setLog_type("VERBOSE");
        appLogDao.insert(appLog);
    }

    public static void v(String msg) {
        v(msg,MED_PRI);
    }

    public static void w(String msg,String priority) {
        Log.w(TAG,msg);
        AppLog appLog = new AppLog();
        appLog.setCreated_at(new Date().getTime());
        appLog.setTag(TAG);
        appLog.setPriority(priority);
        appLog.setMessage(msg);
        appLog.setLog_type("WARN");
        appLogDao.insert(appLog);
    }

    public static void w(String msg) {
        w(msg,MED_PRI);
    }

}
