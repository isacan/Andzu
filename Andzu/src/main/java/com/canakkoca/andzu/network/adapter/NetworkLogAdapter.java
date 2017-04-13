package com.canakkoca.andzu.network.adapter;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.network.models.NetworkLog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class NetworkLogAdapter extends RecyclerView.Adapter<NetworkLogAdapter.MyViewHolder> {

    private List<NetworkLog> networkLogList;

    private SimpleDateFormat dateFormat;


    public NetworkLogAdapter(List<NetworkLog> networkLogs) {
        this.networkLogList = networkLogs;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_networklog, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NetworkLog networkLog = networkLogList.get(position);
        holder.date.setText(dateFormat.format(new Date(networkLog.getDate())));
        holder.url.setText("[" + networkLog.getRequestType() + "] " + networkLog.getUrl());
        holder.code.setText(networkLog.getResponseCode());
        if(networkLog.getResponseCode().startsWith("2")) {
            holder.status.setBackgroundColor(Color.GREEN);
            holder.code.setTextColor(Color.GREEN);
        }else if(networkLog.getResponseCode().startsWith("4")) {
            holder.status.setBackgroundColor(Color.parseColor("#ffa500"));
            holder.code.setTextColor(Color.parseColor("#ffa500"));
        }else if(networkLog.getResponseCode().startsWith("5")) {
            holder.status.setBackgroundColor(Color.RED);
            holder.code.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return networkLogList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, url, code;
        public ImageView status;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            url = (TextView) view.findViewById(R.id.url);
            code = (TextView) view.findViewById(R.id.code);
            status = (ImageView) view.findViewById(R.id.code_img);
        }
    }
}
