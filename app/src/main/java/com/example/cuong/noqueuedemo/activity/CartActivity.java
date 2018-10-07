package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cuong.noqueuedemo.R;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }


    public static void intentToCartActivity(Activity activity){
        Intent intent = new Intent(activity, CartActivity.class);
        activity.startActivity(intent);
    }

}
