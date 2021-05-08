package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common;

public class MyDateUtils {

    public static Integer getCurrentTimeMillsForCache() {
        return (int) (System.currentTimeMillis() / 1000);
    }

}
