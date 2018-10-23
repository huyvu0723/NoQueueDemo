package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout mLnLBack;
    private Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initialView();
    }

    private void initialView(){
        mLnLBack = findViewById(R.id.linear_layout_icon_back);
        mLnLBack.setOnClickListener(this);
        mBtnOK = findViewById(R.id.button_dong_y);
        mBtnOK.setOnClickListener(this);
    }

    public static void intentToPaymentActivity(Activity activity){
        Intent intent = new Intent(activity, PaymentActivity.class);
        activity.startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_icon_back:
                finish();
                break;
            case R.id.button_dong_y:
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
