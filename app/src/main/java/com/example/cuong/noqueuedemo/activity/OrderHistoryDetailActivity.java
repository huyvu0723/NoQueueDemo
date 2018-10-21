package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.BarCodeManagement.BarcodeManagement;
import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.OrderHistoryDetailAdapter;
import com.example.cuong.noqueuedemo.model.OrderHistoryDetail;

import java.util.ArrayList;

public class OrderHistoryDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private OrderHistoryDetailAdapter mOrderDetailAdapter;
    private ArrayList<OrderHistoryDetail> mOrderDetailList;
    private RecyclerView mRecycleViewOrderDetail;
    private LinearLayout mLnlBack;
    private ImageView mImgBarCode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history_detail);
        initialView();
        initialData();
    }

    private void initialView() {
        mRecycleViewOrderDetail = findViewById(R.id.recycle_view_order_history_detail);
        mRecycleViewOrderDetail.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(OrderHistoryDetailActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecycleViewOrderDetail.setLayoutManager(layoutManager);

        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
        mImgBarCode = findViewById(R.id.image_view_bar_code);

    }

    private void initialData() {
        mOrderDetailList = new ArrayList<>();
        mOrderDetailList.add(new OrderHistoryDetail(R.mipmap.ic_traxanhdaxay, "Trà xanh đá xay", "thêm đường", 35000));
        mOrderDetailList.add(new OrderHistoryDetail(R.mipmap.ic_raisindanish, "Raisin Danish", "", 35000));

        mOrderDetailAdapter = new OrderHistoryDetailAdapter(mOrderDetailList, OrderHistoryDetailActivity.this);
        mRecycleViewOrderDetail.setAdapter(mOrderDetailAdapter);

        Bitmap bitmapBarCode = BarcodeManagement.getBarCode(
                OrderHistoryDetailActivity.this, "123456789", BarcodeManagement.BARCODE);
        mImgBarCode.setImageBitmap(bitmapBarCode);
    }

    public static void intentToOrderHistoryDetailActivity(Activity activity) {
        Intent intent = new Intent(activity, OrderHistoryDetailActivity.class);
        activity.startActivity(intent);
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
