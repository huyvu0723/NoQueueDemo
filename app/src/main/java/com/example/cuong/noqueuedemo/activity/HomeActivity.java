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
//        mNewsList.add(new News(R.mipmap.ic_news, "Trà sửa khoai môn khuyến mãi 50% cho dịp hè"));
        mNewsList.add(new News(R.mipmap.ic_no_news, "Bạn ơi, bạn bỏ quên ly trà sửa này!"));
        mNewsList.add(new News(R.mipmap.ic_food1, "Xôi Bà Chiểu ngon không chịu nổi"));
        mNewsList.add(new News(R.mipmap.ic_food2, "Xá xíu Bà Bảy quận 4 đang khuynh đảo giới trẻ"));
        mNewsList.add(new News(R.mipmap.ic_food3, "Bánh mì hoành thánh ngon lạ kỳ"));
        mNewsList.add(new News(R.mipmap.ic_food4, "Mùa hè thử sức với bánh khọt truyền thống"));

        mNewsAdapter = new NewsAdapter(mNewsList, this);
        mRecycleViewNews.setAdapter(mNewsAdapter);


        mDailyFoodList = new ArrayList<>();
        mDailyFoodList.add(R.mipmap.ic_launcher);
        mDailyFoodList.add(R.mipmap.ic_launcher);
        mDailyFoodList.add(R.mipmap.ic_launcher);

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
