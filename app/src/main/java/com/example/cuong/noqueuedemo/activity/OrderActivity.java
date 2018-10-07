package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.fragment.FoodFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentPagerItemAdapter mAdapter;
    private ImageView mImgBack;
    private LinearLayout mLnlCheckOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initialData();
        intialView();
    }

    private void intialView(){
        mImgBack = findViewById(R.id.image_view_icon_back);
        mImgBack.setOnClickListener(this);
        mLnlCheckOut = findViewById(R.id.linear_layout_checkout_cart);
        mLnlCheckOut.setOnClickListener(this);
    }

    private void initialData() {

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(getApplicationContext());
        creator.add("Cơm", FoodFragment.class);
        creator.add("Canh", FoodFragment.class);
        creator.add("Xào", FoodFragment.class);
        creator.add("Kho", FoodFragment.class);
        creator.add("Món phụ", FoodFragment.class);

        mAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(5);
        SmartTabLayout viewPagerTab = findViewById(R.id.view_pager_tab);
        viewPagerTab.setViewPager(viewPager);
    }


    public static void intentToOrderActivity(Activity activity){
        Intent intent = new Intent(activity, OrderActivity.class);
        activity.startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_checkout_cart:
                CartActivity.intentToCartActivity(OrderActivity.this);
                break;
            case R.id.image_view_icon_back:
                finish();
                break;
        }
    }
}
