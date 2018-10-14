package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.OrderHistoryAdapter;
import com.example.cuong.noqueuedemo.model.OrderDetail;
import com.example.cuong.noqueuedemo.model.OrderHistory;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecycleViewOrderHistory;
    private ArrayList<OrderHistory> mOrderHistoryList;
    private OrderHistoryAdapter mOrderHistoryAdapter;
    private LinearLayout mLnlBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        initialView();
        initialData();
    }

    public static void intentToOrderHistoryActivity(Activity activity) {
        Intent intent = new Intent(activity, OrderHistoryActivity.class);
        activity.startActivity(intent);
    }

    private void initialView() {
        mRecycleViewOrderHistory = findViewById(R.id.recycler_view_order_history);
        mRecycleViewOrderHistory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderHistoryActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecycleViewOrderHistory.setLayoutManager(linearLayoutManager);

        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
    }

    private void initialData() {
        mOrderHistoryList = new ArrayList<>();
        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_1, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_8, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_3, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_4, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_5, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_6, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail("Cà phê đá", 1));
        orderDetailList.add(new OrderDetail("Cà phê sữa", 2));
        mOrderHistoryList.add(new OrderHistory("#060918GGWP", "06/10/2018",
                R.mipmap.ic_7, orderDetailList, 95000, 10));

        orderDetailList = new ArrayList<>();
        mOrderHistoryAdapter = new OrderHistoryAdapter(OrderHistoryActivity.this, mOrderHistoryList);
        mRecycleViewOrderHistory.setAdapter(mOrderHistoryAdapter);
        mOrderHistoryAdapter.setmOnClickToOrderDetail(new OrderHistoryAdapter.OnClickToOrderDetail() {
            @Override
            public void setOnClickToOrderDetail(int position) {
                OrderHistoryDetailActivity.intentToOrderHistoryDetailActivity(OrderHistoryActivity.this);
            }
        });
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
