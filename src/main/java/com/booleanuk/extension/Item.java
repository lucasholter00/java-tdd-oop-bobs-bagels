package com.booleanuk.extension;

public abstract class Item {
    private String sku;
    private float price;
    private String name;
    private String variant;

    public Item(String sku, float price, String name, String variant){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSku(){
        return this.sku;
    }

    public float getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public String getVariant(){
        return this.variant;
    }
}