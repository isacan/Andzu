package com.canakkoca.andzu.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.base.AppLog;
import com.canakkoca.andzu.base.NetworkLog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class AppLogAdapter extends RecyclerView.Adapter<AppLogAdapter.MyViewHolder> {

    private List<AppLog> appLogList;

    private SimpleDateFormat dateFormat;


    public AppLogAdapter(List<AppLog> appLogs) {
        this.appLogList = appLogs;
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
        AppLog appLog = appLogList.get(position);
        holder.date.setText(dateFormat.format(new Date(appLog.getCreated_at())));
        holder.url.setText("[" + appLog.getLog_type() + "] " + appLog.getMessage());
        holder.code.setText(appLog.getPriority());
        if(appLog.getLog_type().equals("INFO")) {
            holder.status.setBackgroundColor(Color.GREEN);
            holder.code.setTextColor(Color.GREEN);
        }else if(appLog.getLog_type().equals("DEBUG")) {
            holder.status.setBackgroundColor(Color.parseColor("#ffa500"));
            holder.code.setTextColor(Color.parseColor("#ffa500"));
        }else if(appLog.getLog_type().equals("ERROR")) {
            holder.status.setBackgroundColor(Color.RED);
            holder.code.setTextColor(Color.RED);
        }else if(appLog.getLog_type().equals("VERBOSE")) {
            holder.status.setBackgroundColor(Color.parseColor("#7f7f00"));
            holder.code.setTextColor(Color.parseColor("#7f7f00"));
        }else if(appLog.getLog_type().equals("WARN")) {
            holder.status.setBackgroundColor(Color.BLUE);
            holder.code.setTextColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return appLogList.size();
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
