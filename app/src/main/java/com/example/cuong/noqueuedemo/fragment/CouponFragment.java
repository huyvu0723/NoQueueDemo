package com.example.cuong.noqueuedemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.activity.CouponDetailActivity;
import com.example.cuong.noqueuedemo.adapter.CouponAdapter;
import com.example.cuong.noqueuedemo.model.Coupon;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;

import java.util.ArrayList;

public class CouponFragment extends Fragment {
    private ArrayList<Coupon> mCouponList;
    private RecyclerView mRecycleViewCoupons;
    private CouponAdapter mCouponAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coupon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialView();
        intialData();
    }

    private void initialView(){
        mRecycleViewCoupons = getView().findViewById(R.id.recycle_view_coupon);
        mRecycleViewCoupons.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecycleViewCoupons.setLayoutManager(layoutManager);

    }

    private void intialData(){
        Bundle bundle = getArguments();
        ArrayList<Coupon> couponList = (ArrayList<Coupon>) bundle.getSerializable(ConstantDataManager.BUNDLE);

        mCouponAdapter = new CouponAdapter(getContext(), couponList);
        mRecycleViewCoupons.setAdapter(mCouponAdapter);
        mCouponAdapter.setOnCouponDetailListener(new CouponAdapter.OnClickCouponDetailCallBack() {
            @Override
            public void setOnClickCouponDetailCallBack(int position) {
                CouponDetailActivity.intentToCouponDetailActivity(getActivity());
            }
        });
    }
}
