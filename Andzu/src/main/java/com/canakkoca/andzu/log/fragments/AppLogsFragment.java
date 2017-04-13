package com.canakkoca.andzu.log.fragments;

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
import com.canakkoca.andzu.network.activities.NetworkLogDetailActivity;
import com.canakkoca.andzu.network.adapter.NetworkLogAdapter;
import com.canakkoca.andzu.network.models.DaoSession;
import com.canakkoca.andzu.network.models.NetworkLog;
import com.canakkoca.andzu.network.models.NetworkLogDao;
import com.canakkoca.andzu.utils.RecyclerTouchListener;
import com.drivemode.timberlorry.TimberLorry;
import com.drivemode.timberlorry.payload.Payload;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class AppLogsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_applogs,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        TimberLorry.getInstance().load(new ButtonClick(System.currentTimeMillis()));

    }

    public class ButtonClick implements Payload {
        private final long timeInMillis;

        public ButtonClick(long timeInMillis) {
            this.timeInMillis = timeInMillis;
        }
    }
}
