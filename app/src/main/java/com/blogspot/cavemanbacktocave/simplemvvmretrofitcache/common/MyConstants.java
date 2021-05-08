package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common;

public interface MyConstants {
    public boolean IS_IN_DEBUG = false;
    String BASE_URL = "https://run.mocky.io/v3/";

    Integer MVVM_CACHE_TIME_VERY_LOW_PRIORITY_DATA = 60 * 60 * 5;// 5 HR
    Integer MVVM_CACHE_TIME_LOW_PRIORITY_DATA = 60 * 60; // 1 HR
    Integer MVVM_CACHE_TIME_MEDIUM_PRIORITY_DATA = 2 * 60;// 2 MINS (mins*60)
}
