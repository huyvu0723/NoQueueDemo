package com.example.cuong.noqueuedemo.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cuong.noqueuedemo.R;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        delaySplashScreen();
    }

    private void delaySplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, SPLASH_TIME_OUT);
    }
}
