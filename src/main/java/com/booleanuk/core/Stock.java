package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Item> stock;

    public Stock(){
        stock = new ArrayList<>();

        stock.addAll(List.of(new Bagel("BGLO", 0.49f, "Onion"),
                             new Bagel("BGLP", 0.39f, "Plain"),
                             new Bagel("BGLE", 0.49f, "Everything"),
                             new Bagel("BGLS", 0.49f, "Sesame"),
                             new Coffee("COFB", 0.99f,  "Black"),
                             new Coffee("COFW", 1.19f,  "White"),
                             new Coffee("COFC", 1.29f,  "Cappuccino"),
                             new Coffee("COFL", 1.29f,  "Latte"),
                             new Filling("FILB", 0.12f,  "Bacon"),
                             new Filling("FILE", 0.12f,  "Egg"),
                             new Filling("FILC", 0.12f,  "Cheese"),
                             new Filling("FILX", 0.12f,  "Cream Cheese"),
                             new Filling("FILS", 0.12f,  "Smoked Salmon"),
                             new Filling("FILH", 0.12f,  "Ham")));
    }

    public float getPrice(String sku){
        for(Item item : this.stock){
            if(item.getSku().equals(sku)){
                return item.getPrice();
            }
        }
        return -1f;
    }

    public List<Item> getFillings(){
        List<Item> retList = new ArrayList<>();

        for(Item item : this.stock){
            if(item.getName().equals("Filling")){
                retList.add(item);
            }
        }
        return retList;
    }

    public Item getItem(String sku){
        for(Item item : this.stock){
            if(item.getSku().equals(sku)){
                return item;
            }
        }
        return null;
    }
}