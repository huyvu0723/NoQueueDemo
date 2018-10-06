package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.OrderDetail;
import com.example.cuong.noqueuedemo.model.OrderHistory;

import java.util.ArrayList;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<OrderHistory> mOrderHistoryList;

    public OrderHistoryAdapter(Context mContext, ArrayList<OrderHistory> mOrderHistoryList) {
        this.mContext = mContext;
        this.mOrderHistoryList = mOrderHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_order_history, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderHistory orderHistory = mOrderHistoryList.get(position);
        holder.mTxtOrderCode.setText("Đơn hàng " + orderHistory.getOrderCode());
        holder.mTxtCreatedDate.setText("Ngày " + orderHistory.getCreatedDate());
        holder.mImgPicture.setImageResource(orderHistory.getPicUrl());
        String orderDetailString = "";
        for (OrderDetail orderDetail : orderHistory.getOrderDetailList()){
            orderDetailString += orderDetail.getQuantity() + " x " +
                    orderDetail.getProductName() + "\n";
        }
        holder.mTxtOrderDetail.setText(orderDetailString);
        holder.mTxtTotal.setText(orderHistory.getTotal() + "");
        holder.mTxtPoint.setText("Điểm tích lũy: " + orderHistory.getPoint());
        if(position == (mOrderHistoryList.size() - 1)){
            holder.mLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mOrderHistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTxtOrderCode, mTxtCreatedDate, mTxtOrderDetail,
                mTxtTotal, mTxtPoint;
        private ImageView mImgPicture;
        private View mLine;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxtOrderCode = itemView.findViewById(R.id.text_view_order_code);
            mTxtCreatedDate = itemView.findViewById(R.id.text_view_created_date);
            mTxtOrderDetail = itemView.findViewById(R.id.text_view_order_detail);
            mTxtTotal = itemView.findViewById(R.id.text_view_total);
            mTxtPoint = itemView.findViewById(R.id.text_view_point);
            mImgPicture = itemView.findViewById(R.id.image_view_picture);
            mLine = itemView.findViewById(R.id.view_straight_line);
        }
    }
}
