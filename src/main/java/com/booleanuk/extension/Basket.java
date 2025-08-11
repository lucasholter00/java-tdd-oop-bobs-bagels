package com.booleanuk.extension;

import java.util.*;

public class Basket {
    private List<Item> items;
    private int capacity;
    static private int stdCapacity = 3;
    static private Stock stock = new Stock();

    public Basket(){
        this.capacity = stdCapacity;
        this.initAttributes();
    }

    public Basket(int capacity){
        this.capacity = capacity;
        this.initAttributes();
    }

    private void initAttributes(){
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

    public void updatePriceInfo(){
        //this.priceInfo.clear();

        Map<String, Integer> itemCount = countItems();

    }

    public List<PriceInfo> getPriceInfo(){
        Map<String, Integer> inputMap = this.countItems();
        List<PriceInfo> infos = new ArrayList<>();

        Set<Map.Entry<String, Integer>> entries = inputMap.entrySet();

        for(Map.Entry<String, Integer> entry : entries) {

            Item item = stock.getItem(entry.getKey());
            String name = item.getVariant() + " " + item.getName();

            PriceInfo currInfo = new PriceInfo(name, 0, 0, 0);


            String key = entry.getKey();
            Integer val = entry.getValue();
            while (key.toLowerCase().contains("bgl") && val >= 12) {
                currInfo.incCost(3.99f);
                currInfo.incCount(12);
                currInfo.incDiscount(stock.getPrice(key) * 12 - 3.99f);
                val -= 12;
                entry.setValue(val);
            }

            while (key.toLowerCase().contains("bgl") && val >= 6) {
                currInfo.incCost(2.49f);
                currInfo.incCount(6);
                currInfo.incDiscount(stock.getPrice(key) * 12 - 2.49f);
                val -= 6;
                entry.setValue(val);
            }

            while (val > 0) {
                if (key.toLowerCase().contains("bgl")) {
                    Map.Entry<String, Integer> coffee = findCoffee(entries);
                    if (coffee != null) {
                        coffee.setValue(coffee.getValue() - 1);
                        val -= 1;
                        entry.setValue(val);

                        PriceInfo coffeeCombo = getPriceInfoByName(infos, "Coffee Combo");
                        if(coffeeCombo == null){
                            coffeeCombo = new PriceInfo("Coffee Combo", 0, 0, 0);
                            infos.add(coffeeCombo);
                        }

                        coffeeCombo.incCost(1.25f);
                        coffeeCombo.incCount(1);
                        float discount = stock.getPrice(coffee.getKey()) + stock.getPrice(key) - 1.25f;
                        coffeeCombo.incDiscount(discount);
                        continue; //Used now for simplicity, no good though
                    }
                }
                currInfo.incCost(stock.getPrice(key));
                currInfo.incCount(1);
                val -= 1;
                entry.setValue(val);
            }
            if(currInfo.getCount() > 0) {
                infos.add(currInfo);
            }
        }
        return infos;
    }

    public PriceInfo getPriceInfoByName(List<PriceInfo> entries,String name){
        for(PriceInfo entry : entries){
            if(entry.getName().equals(name)){
                return entry;
            }
        }
        return null;
    }

    public float priceWithDiscount(){

        List<PriceInfo> priceInfos = getPriceInfo();
        float acc = 0;
        for(PriceInfo info : priceInfos){
            acc += info.getCost();
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