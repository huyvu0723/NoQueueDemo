package com.example.cuong.noqueuedemo.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.CouponFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity {

    private FragmentPagerItemAdapter mCouponFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        initialSmartTabLayout();
    }

    private void initialSmartTabLayout() {

        //create creator for managing tabs
        FragmentPagerItems.Creator creator = FragmentPagerItems.with(getApplicationContext());

        creator.add("Chưa sử dụng", CouponFragment.class);
        creator.add("Đã sử dụng", CouponFragment.class);
        creator.add("Đã hết hạn", CouponFragment.class);
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
}
