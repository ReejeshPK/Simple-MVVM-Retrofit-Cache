package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit.response.Resource;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MyRepository myRepository;
    public MyViewModel(@NonNull Application application) {
        super(application);
        myRepository=MyRepository.getInstance();
    }

    public LiveData<Resource<List<MyResponseModel>>> getMyResponseLiveData(){
        return myRepository.getMyResponseWithCache(getApplication());
    }
}
