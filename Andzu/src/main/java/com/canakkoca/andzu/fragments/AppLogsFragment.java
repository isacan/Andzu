package com.canakkoca.andzu.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.adapters.AppLogAdapter;
import com.canakkoca.andzu.base.AndzuApp;
import com.canakkoca.andzu.base.AppLog;
import com.canakkoca.andzu.base.AppLogDao;
import com.canakkoca.andzu.base.DaoSession;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class AppLogsFragment extends Fragment {

    RecyclerView appRecyleView;
    private List<AppLog> appLogs;
    private AppLogDao appLogDao;
    private Query<AppLog> appLogQuery;
    private AppLogAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_applogs,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        appRecyleView = (RecyclerView) view.findViewById(R.id.list_applogs);


        DaoSession daoSession = ((AndzuApp)getActivity().getApplication()).getDaoSession();
        appLogDao = daoSession.getAppLogDao();

        appRecyleView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity()
                .getApplicationContext());
        appRecyleView.setLayoutManager(mLayoutManager);
        appRecyleView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));


        appLogQuery = appLogDao.queryBuilder().orderDesc(AppLogDao.Properties.Id).build();

        appLogs = appLogQuery.list();
        adapter = new AppLogAdapter(appLogs);

        appRecyleView.setAdapter(adapter);
    }


}
