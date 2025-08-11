package com.booleanuk.extension;

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

    public boolean addMult(Basket basket, String sku, int times){
        if(times == 0){
            return true;
        }

        return basket.add(sku) == 1 && addMult(basket, sku, times-1);
    }

    @Test
    public void testPriceWithDiscountNonEmpty(){
        Basket basket = new Basket(50);
        Assertions.assertTrue(addMult(basket, "BGLO", 2));
        Assertions.assertTrue(addMult(basket, "BGLP", 12));
        Assertions.assertTrue(addMult(basket, "BGLE", 6));
        Assertions.assertTrue(addMult(basket, "COFB", 3));

        float delta = 0.001f;

        Assertions.assertEquals(9.97, basket.priceWithDiscount(), delta);

        basket = new Basket(50);

        Assertions.assertTrue(addMult(basket, "BGLP", 16));
        Assertions.assertEquals(5.55, basket.priceWithDiscount(), delta);

    }
}