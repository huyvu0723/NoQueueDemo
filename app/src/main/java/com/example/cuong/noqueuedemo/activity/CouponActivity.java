package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.fragment.CouponFragment;
import com.example.cuong.noqueuedemo.model.Coupon;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLnlBack;
    private FragmentPagerItemAdapter mCouponFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        initialView();
        initialSmartTabLayout();

    }

    public static void intentToCouponActivity(Activity activity) {
        Intent intent = new Intent(activity, CouponActivity.class);
        activity.startActivity(intent);
    }

    private void initialView() {
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
    }


    private void initialSmartTabLayout() {

        //create creator for managing tabs
        FragmentPagerItems.Creator creator = FragmentPagerItems.with(getApplicationContext());

        Bundle bundle = new Bundle();
        ArrayList<Coupon> couponList = new ArrayList<>();
        couponList.add(new Coupon("54.000đ cho BÁNH MÌ PHÚC LONG CÙNG CÀ-PHÊ CHO BUỔI SÁNG", R.mipmap.ic_new1, "30/10/2018"));
        couponList.add(new Coupon("Happy Lunch với 29.000đ", R.mipmap.ic_new7, "30/10/2018"));
        bundle.putSerializable(ConstantDataManager.BUNDLE, couponList);
        creator.add("Chưa sử dụng", CouponFragment.class, bundle);

        bundle = new Bundle();
        couponList = new ArrayList<>();
        couponList.add(new Coupon("Tặng ngay Ly Sứ khi mua nước tại Phúc Long Kha Vạn Cân 1/10/2018", R.mipmap.ic_new4, "30/10/2018"));
        bundle.putSerializable(ConstantDataManager.BUNDLE, couponList);
        creator.add("Đã sử dụng", CouponFragment.class, bundle);

        bundle = new Bundle();
        couponList = new ArrayList<>();
        bundle.putSerializable(ConstantDataManager.BUNDLE, couponList);
        creator.add("Đã hết hạn", CouponFragment.class, bundle);
        //start tabs creating process by creator.create()

        mCouponFragmentAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());
        //viewPager manages fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_coupon);
        viewPager.setAdapter(mCouponFragmentAdapter);
        viewPager.setOffscreenPageLimit(3);
        //set viewPager for SmartTabLayout
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.view_pager_coupon_tab);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_icon_back:
                finish();
                break;
        }
    }
}
