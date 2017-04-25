
package com.canakkoca.andzu.base;

import android.app.Application;

import com.canakkoca.andzu.utils.Logger;

import org.greenrobot.greendao.database.Database;



/**
 * Created by can.akkoca on 4/12/2017.
 */

public class AndzuApp extends Application {

    private DaoSession daoSession;

    private static AndzuApp andzuApp;

    @Override
    public void onCreate() {
        super.onCreate();
        andzuApp = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"andzu-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        Logger.init(this);
    }

    public DaoSession getDaoSession() {
       return daoSession;
    }

    public static AndzuApp getAndzuApp() {
        return andzuApp;
    }
}
