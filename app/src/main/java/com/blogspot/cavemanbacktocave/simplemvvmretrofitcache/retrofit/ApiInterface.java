package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit;

import androidx.lifecycle.LiveData;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseModel;

import java.util.List;

import retrofit2.http.GET;

public interface ApiInterface {

    @GET("bfc63159-1093-4a00-be39-a7b7ffc9f62b")
    LiveData<List<MyResponseModel>> getMyResponseFromApi();
}
