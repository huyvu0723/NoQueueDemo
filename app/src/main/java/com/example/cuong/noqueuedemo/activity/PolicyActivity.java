package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;

public class PolicyActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLnlBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        initialView();
    }

    private void initialView() {
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
    }

    public static void intentToPolicyActivity(Activity activity) {
        Intent intent = new Intent(activity, PolicyActivity.class);
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
