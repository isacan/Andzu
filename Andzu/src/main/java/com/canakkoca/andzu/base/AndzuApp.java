
package com.canakkoca.andzu.base;

import android.app.Application;
import android.util.Log;

import com.canakkoca.andzu.network.models.DaoMaster;
import com.canakkoca.andzu.network.models.DaoSession;


import org.greenrobot.greendao.database.Database;



/**
 * Created by can.akkoca on 4/12/2017.
 */

public class AndzuApp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"andzu-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        Log.d("asdada","asdasdasdasdas");
    }

    public DaoSession getDaoSession() {
       return daoSession;
    }
}
