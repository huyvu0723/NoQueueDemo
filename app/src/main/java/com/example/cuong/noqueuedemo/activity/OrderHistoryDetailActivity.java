package com.example.cuong.noqueuedemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.OrderHistoryDetailAdapter;
import com.example.cuong.noqueuedemo.model.OrderHistoryDetail;

import java.util.ArrayList;

public class OrderHistoryDetailActivity extends AppCompatActivity {
    private OrderHistoryDetailAdapter mOrderDetailAdapter;
    private ArrayList<OrderHistoryDetail> mOrderDetailList;
    private RecyclerView mRecycleViewOrderDetail;


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
    }

    private void initialData() {
        mOrderDetailList = new ArrayList<>();
        mOrderDetailList.add(new OrderHistoryDetail(R.mipmap.ic_launcher, "Cơm gà xối mỡ", "thêm 1 phần Canh ", 37000));
        mOrderDetailList.add(new OrderHistoryDetail(R.mipmap.ic_launcher, "Cơm gà xối mỡ", "thêm 1 phần Canh ", 37000));
        mOrderDetailList.add(new OrderHistoryDetail(R.mipmap.ic_launcher, "Cơm gà xối mỡ", "thêm 1 phần Canh ", 37000));

        mOrderDetailAdapter = new OrderHistoryDetailAdapter(mOrderDetailList, OrderHistoryDetailActivity.this);
        mRecycleViewOrderDetail.setAdapter(mOrderDetailAdapter);
    }
}
