package com.example.cuong.noqueuedemo.model;

public class ProductExtra {
    private int productId;
    private String productName;

    private double unitPrice;

    private boolean checked;

    public ProductExtra(int productId, String productName, double unitPrice, boolean checked) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.checked = checked;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
