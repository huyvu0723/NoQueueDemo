package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.BarCodeManagement.BarcodeManagement;
import com.example.cuong.noqueuedemo.R;

public class CouponDetailActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mImgCoupon;
    private LinearLayout mLnlBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_detail);
        initialView();
        initialData();
    }

    private void initialView(){
        mImgCoupon = findViewById(R.id.image_view_coupon_image);
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
    }

    private void initialData(){
        Bitmap bitmapQRCode = BarcodeManagement.getBarCode(CouponDetailActivity.this,
                "VIETFOOD30", BarcodeManagement.QRCODE);
        mImgCoupon.setImageBitmap(bitmapQRCode);
    }
    public static void intentToCouponDetailActivity(Activity activity){
        Intent intent = new Intent(activity, CouponDetailActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_icon_back:
                finish();
                break;
        }
    }
}
