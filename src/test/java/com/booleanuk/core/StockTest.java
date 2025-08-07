package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StockTest {

    @Test
    public void testGetPriceValidCode(){
        Stock stock = new Stock();

        Assertions.assertEquals(0.49f, stock.getPrice("BGLO"));
        Assertions.assertEquals(1.29f, stock.getPrice("COFL"));
    }

    @Test
    public void testGetPriceInvalidCode(){
        Stock stock = new Stock();

        Assertions.assertEquals(-1, stock.getPrice("erqwer"));
        Assertions.assertEquals(-1, stock.getPrice("\n"));
    }

    @Test
    public void testGetFillings(){
        Stock stock = new Stock();

        List<Item> fillings = stock.getFillings();
        Assertions.assertEquals(6, fillings.size());

        for(Item filling : fillings){
            Assertions.assertEquals("Filling", filling.getName());
        }
    }

    @Test
    public void testGetItemExists(){
        Stock stock = new Stock();

        Assertions.assertEquals("BGLO", stock.getItem("BGLO").getSku());
    }

    @Test
    public void testGetItemCodeDoesNotExist(){
        Stock stock = new Stock();

        Assertions.assertNull(stock.getItem("test").getSku());
    }
}