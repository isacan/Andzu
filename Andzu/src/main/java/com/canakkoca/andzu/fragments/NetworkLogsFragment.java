package com.canakkoca.andzu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.base.AndzuApp;
import com.canakkoca.andzu.base.DaoSession;
import com.canakkoca.andzu.base.NetworkLogDao;
import com.canakkoca.andzu.activities.NetworkLogDetailActivity;
import com.canakkoca.andzu.adapters.NetworkLogAdapter;
import com.canakkoca.andzu.base.NetworkLog;
import com.canakkoca.andzu.utils.RecyclerTouchListener;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class NetworkLogsFragment extends Fragment {


    RecyclerView networkRecyleView;
    private NetworkLogDao networkLogDao;
    private Query<NetworkLog> networkLogQuery;
    private NetworkLogAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_networklogs,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        networkRecyleView = (RecyclerView) view.findViewById(R.id.list_networklogs);

        DaoSession daoSession = ((AndzuApp)getActivity().getApplication()).getDaoSession();
        networkLogDao = daoSession.getNetworkLogDao();

        networkRecyleView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity()
                .getApplicationContext());
        networkRecyleView.setLayoutManager(mLayoutManager);
        networkRecyleView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));

        networkLogQuery = networkLogDao.queryBuilder().orderDesc(NetworkLogDao.Properties.Id).build();

        final List<NetworkLog> networkLogs = networkLogQuery.list();
        adapter = new NetworkLogAdapter(networkLogs);

        networkRecyleView.addOnItemTouchListener(new RecyclerTouchListener(
                getActivity().getApplicationContext()
                , networkRecyleView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity().getApplicationContext()
                        ,NetworkLogDetailActivity.class);
                intent.putExtra("networkLog",networkLogs.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        networkRecyleView.setAdapter(adapter);
    }
}
