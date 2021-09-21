package com.android.planotest;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.android.planotest.base.AccountApplication;


public class T {
    public static void showToast(String msg){
        Toast.makeText(AccountApplication.getActivities().lastElement(),msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(CharSequence c){
        return TextUtils.isEmpty(c);
    }

    public static String getStringByTextView(TextView tv){
        if (null == tv.getText()){
            return "";
        }
        return tv.getText().toString();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static float px2dp(float pxValue) {
        return (pxValue / Resources.getSystem().getDisplayMetrics().density);
    }
}
