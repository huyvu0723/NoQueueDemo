package com.example.cuong.noqueuedemo.model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderHistory implements Serializable {
    private String orderCode;
    private String createdDate;
    private int picUrl;
    private ArrayList<OrderDetail> orderDetailList;
    private double total;
    private int point;

    public OrderHistory(String orderCode, String createdDate, int picUrl, ArrayList<OrderDetail> orderDetailList, double total, int point) {
        this.orderCode = orderCode;
        this.createdDate = createdDate;
        this.picUrl = picUrl;
        this.orderDetailList = orderDetailList;
        this.total = total;
        this.point = point;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public ArrayList<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
