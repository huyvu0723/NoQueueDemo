package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;

import java.util.ArrayList;

public class DailyFoodAdapter extends RecyclerView.Adapter<DailyFoodAdapter.ViewHolder>{
    private ArrayList<Integer> mFoodList;
    private Context mContext;

    public DailyFoodAdapter(ArrayList<Integer> mFoodList, Context mContext) {
        this.mFoodList = mFoodList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_daily_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mImgFood.setImageResource(mFoodList.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImgFood;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgFood = itemView.findViewById(R.id.image_view_food);
        }
    }
}
