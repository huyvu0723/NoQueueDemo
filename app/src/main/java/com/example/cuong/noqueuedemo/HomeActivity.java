package com.example.cuong.noqueuedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView mRecycleViewNews;
    private List<News> mNewsList;
    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialView();
        initialData();
    }

    private void initialView(){
        mRecycleViewNews = findViewById(R.id.recycle_view_news);
        mRecycleViewNews.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(
                HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecycleViewNews.setLayoutManager(linearLayout);

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
    }

    public void getTable(View view) {
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }
}
