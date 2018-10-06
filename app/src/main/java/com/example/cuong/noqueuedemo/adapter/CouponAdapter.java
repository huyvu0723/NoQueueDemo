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
import com.example.cuong.noqueuedemo.model.Coupon;

import java.util.List;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.ViewHolder> {
    private Context mContext;
    private List<Coupon> mCouponList;

    public CouponAdapter(Context mContext, List<Coupon> mCouponList) {
        this.mContext = mContext;
        this.mCouponList = mCouponList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.row_item_coupon, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coupon coupon = mCouponList.get(position);
        holder.mImgPicture.setImageResource(coupon.getImageURL());
        holder.mTxtTitle.setText(coupon.getCouponName());
        holder.mTxtDate.setText(coupon.getExpiredDate());
    }

    @Override
    public int getItemCount() {
        return mCouponList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImgPicture;
        public TextView mTxtTitle, mTxtDate;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgPicture = itemView.findViewById(R.id.image_view_coupon);
            mTxtTitle = itemView.findViewById(R.id.text_view_title_coupon);
            mTxtDate = itemView.findViewById(R.id.text_view_date_coupon);
        }
    }
}
