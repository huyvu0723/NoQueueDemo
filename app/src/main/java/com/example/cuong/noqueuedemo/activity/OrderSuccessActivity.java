package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;

public class OrderSuccessActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnOrderMore;
    private TextView mLnlHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        initialView();
    }

    private void initialView(){
        mBtnOrderMore = findViewById(R.id.button_order_more);
        mBtnOrderMore.setOnClickListener(this);
        mLnlHome = findViewById(R.id.text_view_back_home_page);
        mLnlHome.setOnClickListener(this);
    }

    public static void intentToOrderSuccessActivity(Activity activity){
        Intent intent = new Intent(activity, OrderSuccessActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_order_more:
                OrderActivity.intentToOrderActivity(OrderSuccessActivity.this);
                break;
            case R.id.text_view_back_home_page:
                HomeActivity.intentToHomeActivity(OrderSuccessActivity.this);
                break;
        }
    }
}
