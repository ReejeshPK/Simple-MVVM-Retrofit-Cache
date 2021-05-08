package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_response_table",indices = {@Index(value = "id",unique = true)})
public class MyResponseModel {

    @NonNull
    @PrimaryKey
    public Integer id;
    public String name;
    public Integer lastUpdateTimeMillis;

    public String getName() {
        return name;
    }

    public Integer getLastUpdateTimeMillis() {
        return lastUpdateTimeMillis;
    }

    public void setLastUpdateTimeMillis(Integer lastUpdateTimeMillis) {
        this.lastUpdateTimeMillis = lastUpdateTimeMillis;
    }
}
