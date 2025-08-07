package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StockTest {

    @Test
    public void testGetPriceValidCode(){
        Stock stock = new Stock();

        Assertions.assertEquals(0.49f, stock.getPrice("BGLO"));
        Assertions.assertEquals(1.29f, stock.getPrice("COFL"));
    }

    public void testGetPriceInvalidCode(){
        Stock stock = new Stock();

        Assertions.assertEquals(-1, stock.getPrice("erqwer"));
        Assertions.assertEquals(-1, stock.getPrice("\n"));
    }

    public void testGetFillings(){
        Stock stock = new Stock();

        List<Item> fillings = stock.getFillings();
        Assertions.assertEquals(6, fillings.size());

        for(Item filling : fillings){
            Assertions.assertEquals("Filling", filling.getVariant());
        }
    }
}