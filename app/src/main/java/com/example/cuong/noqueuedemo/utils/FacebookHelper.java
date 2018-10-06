package com.example.cuong.noqueuedemo.utils;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class FacebookHelper {

    public static void handleAccountKitLogin(AppCompatActivity context, String accessToken, final FacebookCallBackData callBackData) {
        if (!accessToken.isEmpty() || accessToken != null || !accessToken.equals("")) {
            Log.e("AccessToken", accessToken);
            callBackData.onSuccess(true);
        } else {
            callBackData.onFail("");
        }
    }
}
