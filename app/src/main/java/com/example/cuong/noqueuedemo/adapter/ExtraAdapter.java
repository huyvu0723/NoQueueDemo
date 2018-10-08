package com.example.cuong.noqueuedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.ProductExtra;

import java.util.ArrayList;

public class ExtraAdapter extends RecyclerView.Adapter<ExtraAdapter.ViewHolder>{

    private ArrayList<ProductExtra> mExtraList;
    private Context mContext;

    public ExtraAdapter(ArrayList<ProductExtra> mExtraList, Context mContext) {
        this.mExtraList = mExtraList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item_extra, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
        ProductExtra extra = mExtraList.get(position);

        holder.mTxtExtraName.setText(extra.getProductName() + " (+"
                + extra.getUnitPrice() + ")");
        holder.mChkExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheckExtra(holder, position); //when users click to check box extra
            }
        });
        holder.mLnlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheckExtra(holder, position);
            }
        });
    }

    private void setCheckExtra(ViewHolder holder, int position) {
        ProductExtra extra = mExtraList.get(position);
        if (extra.isChecked()) { //checked
            extra.setChecked(false);
            holder.mChkExtra.setChecked(extra.isChecked());
        } else { //not checked
            extra.setChecked(true);
            holder.mChkExtra.setChecked(extra.isChecked());
        }
    }

    @Override
    public int getItemCount() {
        return mExtraList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mChkExtra;
        public TextView mTxtExtraName;
        private LinearLayout mLnlRoot;

        public ViewHolder(View itemView) {
            super(itemView);
            mChkExtra = itemView.findViewById(R.id.check_box_extra);
            mTxtExtraName = itemView.findViewById(R.id.text_view_extra_name);
            mLnlRoot = itemView.findViewById(R.id.lnl_root);
        }
    }

}
