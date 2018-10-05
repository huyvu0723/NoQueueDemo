package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
    private List<Food> mFoodList;
    private Context mContext;

    public OrderAdapter(List<Food> mFoodList, Context mContext) {
        this.mFoodList = mFoodList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_food, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = mFoodList.get(position);
        holder.mImgPicture.setImageResource(food.getPicUrl());
        holder.mTxtTitle.setText(food.getProductName());
        holder.mTxtPrice.setText(food.getUnitPrice() + "");

    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImgPicture;
        public TextView mTxtTitle, mTxtPrice, mTxtQuantity;
        public CardView mCardViewFood;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgPicture = itemView.findViewById(R.id.image_view_picture);
            mTxtTitle = itemView.findViewById(R.id.text_view_title);
            mTxtPrice = itemView.findViewById(R.id.text_view_price);
            mTxtQuantity = itemView.findViewById(R.id.text_view_order_selected_quantity);
            mCardViewFood = itemView.findViewById(R.id.card_view_food);
        }
    }
}
