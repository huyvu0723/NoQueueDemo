package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.BarCodeManagement.BarcodeManagement;
import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.CouponAdapter;
import com.example.cuong.noqueuedemo.fragment.MemberTypeFragment;
import com.example.cuong.noqueuedemo.model.Coupon;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

public class MemberCardActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImgBarCode;
    private RecyclerView mRecyclerViewCoupons;
    private CouponAdapter mCouponAdapter;
    private List<Coupon> mCouponList;
    private FragmentPagerItemAdapter mMemberFragmentAdapter;
    private LinearLayout mLnlBack;
    private TextView mTxtAllCoupons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_card);
        initialView();
        initialData();
        createSmartTabLayout();
    }

    public static void intentToMemberCardActivity(Activity activity) {
        Intent intent = new Intent(activity, MemberCardActivity.class);
        activity.startActivity(intent);
    }

    private void initialView() {
        mImgBarCode = findViewById(R.id.image_view_bar_code);
        mRecyclerViewCoupons = findViewById(R.id.recycle_view_not_used_coupon);
        mRecyclerViewCoupons.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MemberCardActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerViewCoupons.setLayoutManager(layoutManager);
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
        mTxtAllCoupons = findViewById(R.id.text_view_all_coupons);
        mTxtAllCoupons.setOnClickListener(this);
    }

    private void initialData() {
//        Bitmap bitmapBarCode = BarcodeManagement.getBarCode(
//                MemberCardActivity.this, "123456789", BarcodeManagement.BARCODE);
//        mImgBarCode.setImageBitmap(bitmapBarCode);

        mCouponList = new ArrayList<>();
        mCouponList.add(new Coupon("MỪNG NGÀY PHỤ NỮ VIỆT NAM: SWEET SET & FREE UPSIZE",
                R.mipmap.ic_new2, "30/10/2018"));
        mCouponList.add(new Coupon("HAPPY LUNCH - BỮA TRƯA VUI VẺ",
                R.mipmap.ic_new7, "30/10/2018"));

        mCouponAdapter = new CouponAdapter(MemberCardActivity.this, mCouponList);
        mRecyclerViewCoupons.setAdapter(mCouponAdapter);
        mCouponAdapter.setOnCouponDetailListener(new CouponAdapter.OnClickCouponDetailCallBack() {
            @Override
            public void setOnClickCouponDetailCallBack(int position) {
                CouponDetailActivity.intentToCouponDetailActivity(MemberCardActivity.this);
            }
        });
    }

    private void createSmartTabLayout() {
        FragmentPagerItems.Creator creator = FragmentPagerItems.with(getApplicationContext());
        creator.add("Green", MemberTypeFragment.class);
        creator.add("Silver", MemberTypeFragment.class);
        creator.add("Gold", MemberTypeFragment.class);
        mMemberFragmentAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_membership_card_type);
        viewPager.setAdapter(mMemberFragmentAdapter);
        viewPager.setOffscreenPageLimit(3);
        SmartTabLayout viewPagerTab = findViewById(R.id.smart_tab_membership_card_type);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_icon_back:
                finish();
                break;
            case R.id.text_view_all_coupons:
                CouponActivity.intentToCouponActivity(MemberCardActivity.this);
                break;
        }
    }
}
