package com.example.cuong.noqueuedemo.model;

public class OrderHistoryDetail {
    private int picUrl;
    private String productName;
    private String extra;
    private double unitPrice;

    public OrderHistoryDetail(int picUrl, String productName, String extra, double unitPrice) {
        this.picUrl = picUrl;
        this.productName = productName;
        this.extra = extra;
        this.unitPrice = unitPrice;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
