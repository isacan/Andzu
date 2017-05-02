
package com.canakkoca.andzu.base;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.canakkoca.andzu.R;
import com.canakkoca.andzu.bubbles.BubbleLayout;
import com.canakkoca.andzu.bubbles.BubblesManager;
import com.canakkoca.andzu.bubbles.OnInitializedCallback;
import com.canakkoca.andzu.utils.Logger;

import org.greenrobot.greendao.database.Database;



/**
 * Created by can.akkoca on 4/12/2017.
 */

public class AndzuApp extends Application {

    private DaoSession daoSession;

    private static AndzuApp andzuApp;

    public static BubblesManager bubblesManager;
    private static BubbleLayout bubbleView;

    private static boolean isAndzuEnabled;

    @Override
    public void onCreate() {
        super.onCreate();
        andzuApp = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"andzu-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        Logger.init(this);

        registerActivityLifecycleCallbacks(lifecycleCallbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if(isAndzuEnabled)
            bubblesManager.recycle();
    }

    public void initAndzu(){
        if(!isAndzuEnabled) {
            bubblesManager = new BubblesManager.Builder(getApplicationContext())
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
    }

    private void addNewBubble() {
        bubbleView = (BubbleLayout) LayoutInflater.from(this).inflate(R.layout.bubble_layout, null);
        bubbleView.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {

            @Override
            public void onBubbleClick(BubbleLayout bubble) {
                Intent i = new Intent(getApplicationContext(),MainAndzuActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
        bubbleView.setShouldStickToWall(false);
        bubblesManager.addBubble(bubbleView, 60, 20);
    }

    private ActivityLifecycleCallbacks lifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityStarted(Activity activity) {
            ActiveActivitiesTracker.activityStarted();
        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            ActiveActivitiesTracker.activityStopped();
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    private static class ActiveActivitiesTracker {
        private static int sActiveActivities = 0;

        public static void activityStarted()
        {
            if( sActiveActivities == 0 )
            {
                if(isAndzuEnabled)
                    bubbleView.setVisibility(View.VISIBLE);
            }
            sActiveActivities++;
        }

        public static void activityStopped()
        {
            sActiveActivities--;
            if( sActiveActivities == 0 )
            {
                if(isAndzuEnabled)
                    bubblesManager.recycle();
            }
        }
    }

    public DaoSession getDaoSession() {
       return daoSession;
    }

    public static AndzuApp getAndzuApp() {
        return andzuApp;
    }
}
