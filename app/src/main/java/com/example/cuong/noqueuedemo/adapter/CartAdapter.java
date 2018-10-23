package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.OrderHistoryDetail;
import com.example.cuong.noqueuedemo.utils.CurrencyManager;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private ArrayList<OrderHistoryDetail> mFoodList;
    private Context mContext;
    private OnClickToFoodItem mOnClickToFoodItem;

    public void setmOnClickToFoodItem(OnClickToFoodItem mOnClickToFoodItem) {
        this.mOnClickToFoodItem = mOnClickToFoodItem;
    }

    public CartAdapter(ArrayList<OrderHistoryDetail> mFoodList, Context mContext) {
        this.mFoodList = mFoodList;
        this.mContext = mContext;
    }

    public interface OnClickToFoodItem{
        void setOnClickToItem(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_order_history_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        OrderHistoryDetail orderHistoryDetail = mFoodList.get(position);
        holder.mImgFood.setImageResource(orderHistoryDetail.getPicUrl());
        holder.mFoodName.setText(orderHistoryDetail.getProductName());
        holder.mTxtExtra.setText(orderHistoryDetail.getExtra());
        holder.mTxtTotal.setText(CurrencyManager.getPrice(orderHistoryDetail.getUnitPrice(), "đ"));
        holder.mLnlFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickToFoodItem.setOnClickToItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImgFood;
        public TextView mFoodName, mTxtExtra, mTxtTotal;
        public FrameLayout mLnlFoodItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgFood = itemView.findViewById(R.id.image_view_order_history_detail);
            mFoodName = itemView.findViewById(R.id.text_view_product_name);
            mTxtExtra = itemView.findViewById(R.id.text_view_extra);
            mTxtTotal = itemView.findViewById(R.id.text_view_unit_price);
            mLnlFoodItem = itemView.findViewById(R.id.linear_layout_food_item);

        }
    }
}
