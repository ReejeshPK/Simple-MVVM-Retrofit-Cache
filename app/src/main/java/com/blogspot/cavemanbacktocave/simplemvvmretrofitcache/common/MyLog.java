package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common;

import android.util.Log;

public class MyLog {
    public static void d(String TAG,String message){
        if(MyConstants.IS_IN_DEBUG){
            Log.d(TAG,message);
        }
    }
}
