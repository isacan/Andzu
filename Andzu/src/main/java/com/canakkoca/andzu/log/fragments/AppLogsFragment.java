package com.canakkoca.andzu.log.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.log.models.AppLog;
import com.canakkoca.andzu.utils.Util;

import java.util.List;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class AppLogsFragment extends Fragment {

    private List<AppLog> appLogs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_applogs,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        String log = Util.readLogs().toString();
        Log.d("asd","asd");

    }


}
