package com.canakkoca.andzu.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.bubbles.BubbleLayout;
import com.canakkoca.andzu.bubbles.BubblesManager;
import com.canakkoca.andzu.bubbles.OnInitializedCallback;

/**
 * Created by can.akkoca on 4/11/2017.
 */

public class AndzuActivity extends AppCompatActivity {

    public BubblesManager bubblesManager;
    private BubbleLayout bubbleView;

    private boolean isAndzuEnabled;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isAndzuEnabled)
            bubbleView.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isAndzuEnabled)
            bubbleView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isAndzuEnabled)
            bubblesManager.recycle();
    }

    public void initAndzu(){
        bubblesManager = new BubblesManager.Builder(this)
                .setInitializationCallback(new OnInitializedCallback() {
                    @Override
                    public void onInitialized() {
                        isAndzuEnabled = true;
                        addNewBubble();
                    }
                })
                .build();
        bubblesManager.initialize();
    }

    private void addNewBubble() {
        bubbleView = (BubbleLayout) LayoutInflater.from(this).inflate(R.layout.bubble_layout, null);
        bubbleView.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {

            @Override
            public void onBubbleClick(BubbleLayout bubble) {
                startActivity(new Intent(getApplicationContext(), MainAndzuActivity.class));
            }
        });
        bubbleView.setShouldStickToWall(false);
        bubblesManager.addBubble(bubbleView, 60, 20);
    }

}
