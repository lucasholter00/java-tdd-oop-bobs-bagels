package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddCorrectItemBasketNotFull(){
        Basket basket = new Basket(3);
        Assertions.assertTrue(basket.getItems().isEmpty());
        Assertions.assertEquals(1, basket.add("BGLO"));
        Assertions.assertFalse(basket.getItems().isEmpty());
    }

    @Test
    public void testAddIncorrectItemBasketNotFull() {
        Basket basket = new Basket(3);
        Assertions.assertTrue(basket.getItems().isEmpty());
        Assertions.assertEquals(-1, basket.add("test"));
        Assertions.assertTrue(basket.getItems().isEmpty());
    }

    @Test
    public void testAddCorrectItemBasketFull(){
        Basket basket = new Basket(3);
        basket.add("BGLO");
        basket.add("BGLO");
        basket.add("BGLO");

        Assertions.assertEquals(0, basket.add("BGLO"));
    }

    @Test
    public void testRemovePresentItem(){
        Basket basket = new Basket(3);
        basket.add("BGLO");

        Assertions.assertTrue(basket.remove("BGLO"));
        Assertions.assertTrue(basket.getItems().isEmpty());
    }

    @Test
    public void testRemoveNonPresentItem(){
        Basket basket = new Basket(3);
        basket.add("BGLO");

        Assertions.assertFalse(basket.remove("test"));
        Assertions.assertEquals(1, basket.getItems().size());
    }

    @Test
    public void testGetTotalCostItemsPresent(){
        Basket basket = new Basket(3);
        basket.add("BGLO");
        Assertions.assertEquals(0.49, basket.getTotalCost(), 0.0001f);

        basket.add("BGLO");
        Assertions.assertEquals(0.98, basket.getTotalCost(), 0.0001f);
    }

    @Test
    public void testGetTotalCostEmpty(){
        Basket basket = new Basket(3);
        Assertions.assertEquals(0, basket.getTotalCost());
    }
}