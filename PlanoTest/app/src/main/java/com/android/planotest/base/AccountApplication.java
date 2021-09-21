package com.android.planotest.base;

import android.app.Application;

import java.util.Vector;

public class AccountApplication extends Application {
    private static AccountApplication mInstance;
    private static Vector<BaseActivity> mActivities = new Vector<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static AccountApplication getApplication(){
        return mInstance;
    }

    public static void addActivity(BaseActivity activity){
        mActivities.add(activity);
    }

    public static void removeActivity(BaseActivity activity){
        mActivities.remove(activity);
    }

    public static Vector<BaseActivity> getActivities(){
        return mActivities;
    }
}
