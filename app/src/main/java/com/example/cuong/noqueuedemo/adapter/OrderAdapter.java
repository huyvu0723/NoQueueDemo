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
import com.example.cuong.noqueuedemo.model.Product;
import com.example.cuong.noqueuedemo.utils.CurrencyManager;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
    private List<Product> mProductList;
    private Context mContext;
    private OnClickToProductItem mOnClickToProductItem;

    public void setmOnClickToProductItem(OnClickToProductItem mOnClickToProductItem) {
        this.mOnClickToProductItem = mOnClickToProductItem;
    }

    public OrderAdapter(List<Product> mProductList, Context mContext) {
        this.mProductList = mProductList;
        this.mContext = mContext;
    }

    public interface OnClickToProductItem{
        void setOnClickToProductItem(int position);
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Product product = mProductList.get(position);
        holder.mImgPicture.setImageResource(product.getPicUrl());
        holder.mTxtTitle.setText(product.getProductName());
        holder.mTxtPrice.setText(CurrencyManager.getPrice(product.getUnitPrice(), " đ"));
        holder.mCardViewFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickToProductItem.setOnClickToProductItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImgPicture;
        public TextView mTxtTitle, mTxtPrice, mTxtQuantity;
        public CardView mCardViewFood;
        public CardView mCardViewFoodItem;


        public ViewHolder(View itemView) {
            super(itemView);
            mImgPicture = itemView.findViewById(R.id.image_view_picture);
            mTxtTitle = itemView.findViewById(R.id.text_view_title);
            mTxtPrice = itemView.findViewById(R.id.text_view_price);
            mTxtQuantity = itemView.findViewById(R.id.text_view_order_selected_quantity);
            mCardViewFood = itemView.findViewById(R.id.card_view_food);
            mCardViewFoodItem = itemView.findViewById(R.id.card_view_food);
        }
    }
}
