package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.adapter.DailyFoodAdapter;
import com.example.cuong.noqueuedemo.adapter.NewsAdapter;
import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.model.News;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView mRecycleViewNews, mRecycleViewDailyFood;
    private List<News> mNewsList;
    private List<Integer> mDailyFoodList;
    private NewsAdapter mNewsAdapter;
    private DailyFoodAdapter mDailyFoodAdapter;
    private LinearLayout mLnlProfile, mLnlScanQR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialView();
        initialData();
    }

    public static void intentToHomeActivity(Activity activity){
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
    }

    private void initialView(){
        mRecycleViewNews = findViewById(R.id.recycle_view_news);
        mRecycleViewNews.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(
                HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecycleViewNews.setLayoutManager(linearLayout);

        mLnlProfile = findViewById(R.id.linear_layout_user_pircture);
        mLnlProfile.setOnClickListener(this);
        mLnlScanQR = findViewById(R.id.linear_layout_scan_qr);
        mLnlScanQR.setOnClickListener(this);

        mRecycleViewDailyFood = findViewById(R.id.recycle_view_dayli_food);
        mRecycleViewDailyFood.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(
                HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mRecycleViewDailyFood.setLayoutManager(linearLayout);

    }

    private void initialData(){
        mNewsList = new ArrayList<>();
        mNewsList.add(new News(R.mipmap.ic_new1, "BÁNH MÌ PHÚC LONG CÙNG CÀ-PHÊ CHO BUỔI SÁNG"));
        mNewsList.add(new News(R.mipmap.ic_new2, "MỪNG NGÀY PHỤ NỮ VIỆT NAM: SWEET SET & FREE UPSIZE"));
        mNewsList.add(new News(R.mipmap.ic_new3, "KẾT NỐI YÊU THƯƠNG CÙNG BÁNH TRUNG THU PHÚC LONG"));
        mNewsList.add(new News(R.mipmap.ic_new4, "MỪNG KHAI TRƯƠNG - PHÚC LONG KHA VẠN CÂN"));
        mNewsList.add(new News(R.mipmap.ic_new5, "ĂN BÁNH THƯỞNG TRÀ PHÚC LONG THẢ GA"));
        mNewsList.add(new News(R.mipmap.ic_new6, "MỪNG KHAI TRƯƠNG - PHÚC LONG VINCOM QUANG TRUNG"));

        mNewsAdapter = new NewsAdapter(mNewsList, this);
        mRecycleViewNews.setAdapter(mNewsAdapter);


        mDailyFoodList = new ArrayList<>();
        mDailyFoodList.add(R.mipmap.ic_traxanhdaxay);
        mDailyFoodList.add(R.mipmap.ic_passioncheesepax);
        mDailyFoodList.add(R.mipmap.ic_chocolatecroissant);
        mDailyFoodList.add(R.mipmap.ic_butter_croissant);

        mDailyFoodAdapter = new DailyFoodAdapter((ArrayList<Integer>) mDailyFoodList,HomeActivity.this);
        mRecycleViewDailyFood.setAdapter(mDailyFoodAdapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_user_pircture:
                ProfileActivity.intentToProfileActivity(HomeActivity.this);
                break;
            case R.id.linear_layout_scan_qr:
                ScanQRActivity.intentToScanQRActivity(HomeActivity.this);
                break;
        }
    }
}
