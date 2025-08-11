package com.booleanuk.extension;

public class PriceInfo {
    private String name;
    private int count;
    private float discount;
    private float cost;

    public PriceInfo(String name, int count, float cost, float discount){
        this.name = name;
        this.count = count;
        this.cost = cost;
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void incDiscount(float add){
        this.setDiscount(this.getDiscount() + add);
    }

    public void incCount(int add){
        this.setCount(this.getCount() + add);
    }

    public void incCost(float add){
        this.setCost(this.getCost() + add);
    }

}
