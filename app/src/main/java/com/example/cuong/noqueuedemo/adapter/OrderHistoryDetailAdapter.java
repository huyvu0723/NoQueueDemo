package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.OrderHistoryDetail;
import com.example.cuong.noqueuedemo.utils.CurrencyManager;

import java.util.List;

public class OrderHistoryDetailAdapter extends RecyclerView.Adapter<OrderHistoryDetailAdapter.ViewHolder> {
    private List<OrderHistoryDetail> mOrderDetailList;
    private Context mContext;

    public OrderHistoryDetailAdapter(List<OrderHistoryDetail> mOrderDetailList, Context mContext) {
        this.mOrderDetailList = mOrderDetailList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_order_history_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderHistoryDetail orderHistoryDetail = mOrderDetailList.get(position);
        holder.mImgOrderDetail.setImageResource(orderHistoryDetail.getPicUrl());
        holder.mTxtProductName.setText(orderHistoryDetail.getProductName());
        holder.mTxtExtra.setText(orderHistoryDetail.getExtra());
        holder.mTxtUnitPrice.setText(CurrencyManager.getPrice(orderHistoryDetail.getUnitPrice(), "đ"));

    }

    @Override
    public int getItemCount() {
        return mOrderDetailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgOrderDetail;
        private TextView mTxtProductName, mTxtExtra, mTxtUnitPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgOrderDetail = itemView.findViewById(R.id.image_view_order_history_detail);
            mTxtProductName = itemView.findViewById(R.id.text_view_product_name);
            mTxtExtra = itemView.findViewById(R.id.text_view_extra);
            mTxtUnitPrice = itemView.findViewById(R.id.text_view_unit_price);
        }
    }
}
