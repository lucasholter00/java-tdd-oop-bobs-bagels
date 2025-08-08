package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items;
    private int capacity;
    static private int stdCapacity = 3;
    static private Stock stock = new Stock();

    public Basket(){
        this.capacity = stdCapacity;
        items = new ArrayList<>();
    }

    public Basket(int capacity){
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public List<Item> getItems(){
        return this.items;
    }

    public int add(String sku) {
        if(items.size() >= capacity){
            return 0;
        }

        Item addItem = stock.getItem(sku);

        if(addItem == null){
            return -1;
        }

        items.add(addItem);
        return 1;
    }

    public boolean remove(String sku){
        for(int i = 0; i < this.items.size(); i++){
            if(this.items.get(i).getSku().equals(sku)){
                this.items.remove(i);
                return true;
            }
        }
        return false;
    }

    public float getTotalCost(){
        float acc = 0.0f;
        for(Item curr : this.items){
            acc = acc + curr.getPrice();
            System.out.println(curr.getPrice());
        }
        return acc;
    }
}