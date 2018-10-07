package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;

public class CustomerInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout mLnlBack;
    private Button mBtnSaveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        initialView();
    }

    public static void intentToCustomerInfoActivity(Activity activity){
        Intent intent = new Intent(activity, CustomerInfoActivity.class);
        activity.startActivity(intent);
    }

    private void initialView(){
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
        mBtnSaveInfo = findViewById(R.id.button_save_info);
        mBtnSaveInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_icon_back:
                finish();
                break;
            case R.id.button_save_info:
                finish();
                break;
        }
    }
}
