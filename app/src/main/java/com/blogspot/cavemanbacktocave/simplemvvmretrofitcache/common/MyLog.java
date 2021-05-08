package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common;

import android.util.Log;

public class MyLog {
    static void d(String TAG,String message){
        if(MyConstants.IS_IN_DEBUG){
            Log.d(TAG,message);
        }
    }
}
