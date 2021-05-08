package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common.AppExecutors;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common.MyConstants;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common.MyDateUtils;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.common.MyLog;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.magic.NetworkBoundResource;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit.RetrofitClient;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit.response.ApiResponse;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit.response.Resource;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.roomdb.MyRoomDb;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyRepository {

    private MyRepository(){

    }

    private String TAG = MyRepository.class.getSimpleName();

    private static MyRepository myRepository = null;

    public static MyRepository getInstance() {
        if (myRepository == null) {
            myRepository = new MyRepository();
        }
        return myRepository;
    }

    public LiveData<Resource<List<MyResponseModel>>> getMyResponseWithCache(Context context) {
        /*In case you have both different model refer :
         * https://github.com/mitchtabian/Local-db-Cache-Retrofit-REST-API-MVVM/blob/master/app/src/main/java/com/codingwithmitch/foodrecipes/repositories/RecipeRepository.java
         * */
        return new NetworkBoundResource<List<MyResponseModel>, List<MyResponseModel>>(AppExecutors.getInstance()) {
            MyResponseDao myResponseDao = MyRoomDb.getDatabase(context).getMyResponseDao();

            @Override
            protected void saveCallResult(@NonNull List<MyResponseModel> item) {
                MyLog.d(TAG, "SaveCallResults:getMyResponseWithCache");
                for (MyResponseModel myResponseModel : item) {
                    myResponseModel.setLastUpdateTimeMillis(MyDateUtils.getCurrentTimeMillsForCache());
                    myResponseDao.insert(myResponseModel);
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<MyResponseModel> data) {
                MyLog.d(TAG, "shouldFetch:getMyResponseWithCache");
                //decide wheater to get from api or get from local db - write your logic
                if ((data == null) || (data.size() == 0)) {
                    return true;
                }
                int currentTime = (int) (System.currentTimeMillis() / 1000);
                MyLog.d(TAG, "shouldFetch: current time getMyResponseWithCache: " + currentTime);
                MyResponseModel veryOldestData = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    veryOldestData = Collections.min(data, Comparator.comparing(s -> s.getLastUpdateTimeMillis()));
                } else {
                    Collections.sort(data, new Comparator<MyResponseModel>() {
                        @Override
                        public int compare(MyResponseModel o1, MyResponseModel o2) {
                            return o1.getLastUpdateTimeMillis().compareTo(o2.getLastUpdateTimeMillis());
                        }
                    });
                    veryOldestData = data.get(0);
                }
                if (veryOldestData != null) {
                    int lastRefresh = veryOldestData.getLastUpdateTimeMillis();
                    //for testing
                    printLastCalledTime(lastRefresh, currentTime, "getMyResponseWithCache");
                    if ((currentTime - veryOldestData.getLastUpdateTimeMillis()) >= MyConstants.MVVM_CACHE_TIME_MEDIUM_PRIORITY_DATA) {
                        MyLog.d(TAG, "shouldFetch: SHOULD REFRESH RECIPE?getMyResponseWithCache! " + true);
                        return true;
                    }
                    MyLog.d(TAG, "shouldFetch: SHOULD REFRESH RECIPE?getMyResponseWithCache! " + false);
                }
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<MyResponseModel>> loadFromDb() {
                MyLog.d(TAG, "loadFromDb:getMyResponseWithCache");
                return RetrofitClient.getApiInterface().getMyResponseFromApi();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<MyResponseModel>>> createCall() {
                MyLog.d(TAG, "createCall:");
                return null;
            }
        }.getAsLiveData();
    }


    private void printLastCalledTime(int lastRefresh, int currentTime, String funcitonName) {

        MyLog.d(TAG, funcitonName + "shouldFetch: last refresh: " + lastRefresh);
        MyLog.d(TAG, funcitonName + "shouldFetch: it's been " + ((currentTime - lastRefresh) / 60 / 60 / 24) +
                " days since this recipe was refreshed.  ");
        MyLog.d(TAG, funcitonName + "shouldFetch: it's been " + ((currentTime - lastRefresh) / 60 / 60) +
                " hours since this recipe was refreshed. ");
        MyLog.d(TAG, funcitonName + "shouldFetch: it's been " + ((currentTime - lastRefresh) / 60) +
                " minutes since this recipe was refreshed.  ");
        MyLog.d(TAG, funcitonName + "shouldFetch: it's been " + ((currentTime - lastRefresh)) +
                " seconds since this recipe was refreshed.  ");
    }
}
