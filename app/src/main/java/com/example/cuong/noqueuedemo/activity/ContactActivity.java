package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLnlBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initialView();
    }

    public static void intentToContactActivity(Activity activity) {
        Intent intent = new Intent(activity, ContactActivity.class);
        activity.startActivity(intent);
    }

    private void initialView(){
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
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
