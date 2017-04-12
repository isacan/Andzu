package com.canakkoca.andzu.network.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.base.AndzuApp;
import com.canakkoca.andzu.network.models.DaoSession;
import com.canakkoca.andzu.network.models.NetworkLog;
import com.canakkoca.andzu.network.models.NetworkLogDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by can.akkoca on 4/12/2017.
 */

public class NetworkLogsActivity extends AppCompatActivity {

    RecyclerView networkRecyleView;
    private NetworkLogDao networkLogDao;
    private Query<NetworkLog> networkLogQuery;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networklogs);

        networkRecyleView = (RecyclerView) findViewById(R.id.list_networklogs);

        DaoSession daoSession = ((AndzuApp)getApplication()).getDaoSession();
        networkLogDao = daoSession.getNetworkLogDao();

        networkLogQuery = networkLogDao.queryBuilder().orderAsc(NetworkLogDao.Properties.Id).build();
        List<NetworkLog> networkLogs = networkLogQuery.list();
        Log.d("ads","asda");
    }
}
