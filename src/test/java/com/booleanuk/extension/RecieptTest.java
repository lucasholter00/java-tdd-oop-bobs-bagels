package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class RecieptTest {

    private boolean addMult(Basket basket, String sku, int times){
        boolean ret = true;
        for(int i = 0; i < times; i++){
          ret = ret && basket.add(sku) == 1;
        }

        return ret;
    }

    @Test
    public void testPrintRecieptNormal(){

        Basket basket = new Basket(50);
        addMult(basket,"BGLO", 2);
        addMult(basket,"BGLP", 12);
        addMult(basket,"BGLE", 6);
        addMult(basket,"COFB", 3);

        Reciept reciept = new Reciept(basket);
        System.out.println(reciept.getReciept());
        Assertions.assertTrue(reciept.getReciept().contains("Plain Bagel        12  £3.99"));
        Assertions.assertTrue(reciept.getReciept().contains("Everything Bagel   6   £2.49"));
        Assertions.assertTrue(reciept.getReciept().contains("Black Coffee       1   £0.99"));
        Assertions.assertTrue(reciept.getReciept().contains("Coffee Combo       2   £2.5"));
        Assertions.assertTrue(reciept.getReciept().contains("Total                  £9.97"));
    }

    @Test
    public void testPrintDiscountedRecieptNormal(){

        Basket basket = new Basket(50);
        addMult(basket,"BGLO", 2);
        addMult(basket,"BGLP", 12);
        addMult(basket,"BGLE", 6);
        addMult(basket,"COFB", 3);

        Reciept reciept = new Reciept(basket);
        System.out.println(reciept.getDiscountedReciept());
        Assertions.assertTrue(reciept.getDiscountedReciept().contains("Plain Bagel        12  £3.99\n" +
                                                                      "                     (-£0.69)"));
        Assertions.assertTrue(reciept.getDiscountedReciept().contains("Everything Bagel   6   £2.49\n" +
                                                                     "                     (-£0.45)"));
        Assertions.assertTrue(reciept.getDiscountedReciept().contains("Black Coffee       1   £0.99"));
        Assertions.assertTrue(reciept.getDiscountedReciept().contains("Coffee Combo       2   £2.5"));
        Assertions.assertTrue(reciept.getDiscountedReciept().contains("Total                  £9.97"));
    }
}
