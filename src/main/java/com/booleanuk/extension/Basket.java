package com.booleanuk.extension;

import java.util.*;

public class Basket {
    private List<Item> items;
    private int capacity;
    //private Reciept reciept;
    static private int stdCapacity = 3;
    static private Stock stock = new Stock();

    public Basket(){
        this.capacity = stdCapacity;
    }

    public Basket(int capacity){
        this.capacity = capacity;
        initAttributes();
    }

    private void initAttributes(){
        items = new ArrayList<>();
        //this.reciept = new Reciept(items, stock);
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
        }
        return acc;
    }

    private Map<String, Integer> countItems(){
        Map<String, Integer> itemCount = new HashMap<>();
        for(Item item : this.items){
            String sku = item.getSku();

            itemCount.putIfAbsent(sku, 0);
            itemCount.put(sku, itemCount.get(sku)+1);

            if(item instanceof Bagel){
                Bagel bagel = (Bagel) item;
                for(Filling filling : bagel.getFillings()){
                    sku = filling.getSku();
                    itemCount.putIfAbsent(sku, 0);
                    itemCount.put(sku, itemCount.get(sku)+1);
                }
            }
        }
        return itemCount;
    }

    public float priceWithDiscount(){

        Map<String, Integer> itemCount = countItems();

        Set<Map.Entry<String, Integer>> itemCountVals = itemCount.entrySet();

        float acc = 0;
        System.out.println(itemCount);
        for(Map.Entry<String, Integer> entry : itemCountVals){
            String key = entry.getKey();
            Integer val = entry.getValue();

            while (key.toLowerCase().contains("bgl") && val >= 12) {
                acc += 3.99f;
                val -= 12;
                entry.setValue(val);
            }

            while (key.toLowerCase().contains("bgl") && val >= 6) {
                acc += 2.49f;
                val -= 6;
                entry.setValue(val);
            }

            while(val > 0) {
                if(key.toLowerCase().contains("bgl")) {
                    Map.Entry<String, Integer> coffee = findCoffee(itemCountVals);
                    if(coffee != null){
                        coffee.setValue(coffee.getValue()-1);
                        val -= 1;
                        entry.setValue(val);
                        acc += 1.25f;
                        continue; //Used now for simplicity, no good though
                    }
                }
                acc += stock.getPrice(key);
                val -= 1;
                entry.setValue(val);
            }
            System.out.println(key);
            System.out.println(acc);

        }
        return acc;
    }

    private Map.Entry<String, Integer> findCoffee(Set<Map.Entry<String, Integer>> itemCount){
        for(Map.Entry<String, Integer> entry : itemCount){
            if(entry.getKey().toLowerCase().contains("cof") && entry.getValue() > 0){
                return entry;
            }
        }
        return null;
    }



    public String getReciept(){
        return "";
    }
}