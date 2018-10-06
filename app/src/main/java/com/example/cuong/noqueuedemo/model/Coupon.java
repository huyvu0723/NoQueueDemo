package com.example.cuong.noqueuedemo.model;

import java.io.Serializable;

public class Coupon implements Serializable{
    private int id;
    private String couponCode;
    private boolean isUsed;
    private boolean isExpired;
    private boolean isInfinity;
    private String couponName;
    private int imageURL;
    private String expiredDate;

    public Coupon(String couponName, int imageURL, String expiredDate) {
        this.couponName = couponName;
        this.imageURL = imageURL;
        this.expiredDate = expiredDate;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isInfinity() {
        return isInfinity;
    }

    public void setInfinity(boolean infinity) {
        isInfinity = infinity;
    }

}
