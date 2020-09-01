package com.bct.hotelapp;

public class BillModel {
    private int billid;
    private String itemName;
    private double price;
    private int quantity;

    public BillModel(int billid, String itemName, double price, int quantity) {
        this.billid = billid;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
