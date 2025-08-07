package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Item> stock;

    public Stock(){
        stock = new ArrayList<>();

        stock.addAll(List.of(new Item("BGLO", 0.49f, "Bagel", "Onion"),
                             new Item("BGLP", 0.39f, "Bagel", "Plain"),
                             new Item("BGLE", 0.49f, "Bagel", "Everything"),
                             new Item("BGLS", 0.49f, "Bagel", "Sesame"),
                             new Item("COFB", 0.99f, "Coffee", "Black"),
                             new Item("COFW", 1.19f, "Coffee", "White"),
                             new Item("COFC", 1.29f, "Coffee", "Capuccino"),
                             new Item("COFL", 1.29f, "Coffee", "Latte"),
                             new Item("FILB", 0.12f, "Filling", "Bacon"),
                             new Item("FILE", 0.12f, "Filling", "Egg"),
                             new Item("FILC", 0.12f, "Filling", "Cheese"),
                             new Item("FILX", 0.12f, "Filling", "Cream Cheese"),
                             new Item("FILS", 0.12f, "Filling", "Smoked Salmon"),
                             new Item("FILH", 0.12f, "Filling", "Ham")));
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
}