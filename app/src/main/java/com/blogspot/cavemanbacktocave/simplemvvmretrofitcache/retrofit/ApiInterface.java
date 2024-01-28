package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit;

import androidx.lifecycle.LiveData;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseModel;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit.response.ApiResponse;

import java.util.List;

import retrofit2.http.GET;

public interface ApiInterface {

    @GET("743d8529-e94f-47d9-bcaa-450519cdebe8")
    LiveData<ApiResponse<List<MyResponseModel>>> getMyResponseFromApi();
}
