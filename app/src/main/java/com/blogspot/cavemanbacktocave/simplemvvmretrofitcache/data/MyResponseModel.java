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

    public String getName() {
        return name;
    }
}
