package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{
    List<Filling> fillings;

    public Bagel(String sku, float price, String variant){
        super(sku, price, "Bagel", variant);
        this.fillings = new ArrayList<>();
    }

    public void addFilling(Filling filling){
        this.fillings.add(filling);
    }

    public boolean removeFilling(String variant){
        for(int i = 0; i < this.fillings.size(); i++){
            if(this.fillings.get(i).getVariant().equals(variant)){
                this.fillings.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Filling> getFillings(){
        return this.fillings;
    }
}
