package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.R;
import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data.MyResponseModel;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MyResponseModel> myResponseModelList = new ArrayList<>();

    public MyAdapter(List<MyResponseModel> myResponseModelList) {
        this.myResponseModelList = myResponseModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mylist, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyResponseModel oneResponse = myResponseModelList.get(position);

        holder.name.setText(oneResponse.getName());
    }

    @Override
    public int getItemCount() {
        return myResponseModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);

        }
    }
}
