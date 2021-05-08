package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyResponseDao {

    //select
    @Query("SELECT * FROM my_response_table")
    LiveData<List<MyResponseModel>> getMyTableContents();

    //insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MyResponseModel myResponseModel);
}
