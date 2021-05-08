package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.R;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler=findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);


        List<MyResponseModel> myResponseModelList=new ArrayList<>();
        MyAdapter myAdapter=new MyAdapter(myResponseModelList);
        recycler.setAdapter(myAdapter);


    }
}