package com.example.cuong.noqueuedemo.model;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private String productName;
    private int quantity;

    public OrderDetail(String productName, int quantity) {

        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
