package com.canakkoca.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.canakkoca.andzu.base.AndzuActivity;
import com.canakkoca.andzu.bubbles.BubbleLayout;
import com.canakkoca.andzu.bubbles.BubblesManager;
import com.canakkoca.andzu.bubbles.OnInitializedCallback;

public class MainActivity extends AndzuActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bubblesManager.recycle();
    }
}
