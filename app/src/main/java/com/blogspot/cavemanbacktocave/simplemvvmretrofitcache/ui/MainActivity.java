package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.R;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseModel;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyViewModel;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.retrofit.response.Resource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel myViewModel=new ViewModelProvider(this).get(MyViewModel.class);

        RecyclerView recycler=findViewById(R.id.recycler);
        ProgressBar progress=findViewById(R.id.progress);
        recycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);


        List<MyResponseModel> myResponseModelList=new ArrayList<>();
        MyAdapter myAdapter=new MyAdapter(myResponseModelList);
        recycler.setAdapter(myAdapter);


        //get data from api / db
        myViewModel.getMyResponseLiveData().observe(this, new Observer<Resource<List<MyResponseModel>>>() {
            @Override
            public void onChanged(Resource<List<MyResponseModel>> listResource) {
                switch (listResource.status){
                    case LOADING:{
                        progress.setVisibility(View.VISIBLE);
                    }
                        break;
                    case SUCCESS:{
                        progress.setVisibility(View.GONE);
                        myResponseModelList.clear();
                        myResponseModelList.addAll(listResource.data);
                        myAdapter.notifyDataSetChanged();
                    }
                        break;
                    case ERROR:{
                        progress.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Sorry, Some Error Occured", Toast.LENGTH_SHORT).show();
                    }
                        break;
                }
            }
        });

    }
}