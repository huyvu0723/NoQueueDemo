package com.example.cuong.noqueuedemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.OrderHistoryAdapter;
import com.example.cuong.noqueuedemo.model.OrderDetail;
import com.example.cuong.noqueuedemo.model.OrderHistory;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {
    private RecyclerView mRecycleViewOrderHistory;
    private ArrayList<OrderHistory> mOrderHistoryList;
    private OrderHistoryAdapter mOrderHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        initialView();
        initialData();
    }

    private void initialView() {
        mRecycleViewOrderHistory = findViewById(R.id.recycler_view_order_history);
        mRecycleViewOrderHistory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderHistoryActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecycleViewOrderHistory.setLayoutManager(linearLayoutManager);
    }

    private void initialData() {
        mOrderHistoryList = new ArrayList<>();
        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cơm gà chiên", 1));
        orderDetailList.add(new OrderDetail("Thịt kho tàu", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_launcher, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cơm gà chiên", 1));
        orderDetailList.add(new OrderDetail("Thịt kho tàu", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_launcher, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cơm gà chiên", 1));
        orderDetailList.add(new OrderDetail("Thịt kho tàu", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_launcher, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cơm gà chiên", 1));
        orderDetailList.add(new OrderDetail("Thịt kho tàu", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_launcher, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cơm gà chiên", 1));
        orderDetailList.add(new OrderDetail("Thịt kho tàu", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_launcher, orderDetailList, 95000, 10));

        mOrderHistoryAdapter = new OrderHistoryAdapter(OrderHistoryActivity.this, mOrderHistoryList);
        mRecycleViewOrderHistory.setAdapter(mOrderHistoryAdapter);
    }
}
