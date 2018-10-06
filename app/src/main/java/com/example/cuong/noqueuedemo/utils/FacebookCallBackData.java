package com.example.cuong.noqueuedemo.utils;

public interface FacebookCallBackData {
    void onSuccess(boolean isLogged);

    void onFail(String message);
}
