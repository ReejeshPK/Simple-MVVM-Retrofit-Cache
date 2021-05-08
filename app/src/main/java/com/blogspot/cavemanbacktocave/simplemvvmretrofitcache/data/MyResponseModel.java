package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_response_table",indices = {@Index(value = "m_id",unique = true)})
public class MyResponseModel {

    @NonNull
    @PrimaryKey
    public Integer m_id;
    public String m_data;
    public Integer lastUpdateTimeMillis;

    public String getName() {
        return m_data;
    }

    public Integer getLastUpdateTimeMillis() {
        return lastUpdateTimeMillis;
    }

    public void setLastUpdateTimeMillis(Integer lastUpdateTimeMillis) {
        this.lastUpdateTimeMillis = lastUpdateTimeMillis;
    }
}
