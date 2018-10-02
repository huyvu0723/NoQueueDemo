package com.example.cuong.noqueuedemo.model;

public class News {
    private int mNewsImage;
    private String mNewsTitle;

    public News(int mNewsImage, String mNewsTitle) {
        this.mNewsImage = mNewsImage;
        this.mNewsTitle = mNewsTitle;
    }

    public int getmNewsImage() {
        return mNewsImage;
    }

    public void setmNewsImage(int mNewsImage) {
        this.mNewsImage = mNewsImage;
    }

    public String getmNewsTitle() {
        return mNewsTitle;
    }

    public void setmNewsTitle(String mNewsTitle) {
        this.mNewsTitle = mNewsTitle;
    }
}
