package com.canakkoca.andzu.base;

import android.accounts.Account;
import android.app.Application;

import com.canakkoca.andzu.network.models.DaoMaster;
import com.canakkoca.andzu.network.models.DaoSession;
import com.drivemode.timberlorry.Config;
import com.drivemode.timberlorry.TimberLorry;
import com.drivemode.timberlorry.output.LogcatOutlet;
import com.drivemode.timberlorry.plug.GsonSerializer;

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

        TimberLorry.initialize(new Config.Builder()
                .collectIn(5)
                .serializeWith(new GsonSerializer())
                .addOutlet(new LogcatOutlet()).build(this));
        TimberLorry.getInstance().schedule();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
