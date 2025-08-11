package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecieptTest {

    public boolean addMult(Basket basket, String sku, int times){
        if(times == 0){
            return true;
        }

        return basket.add(sku) == 1 && addMult(basket, sku, times-1);
    }

    @Test
    public void testPrintRecieptNormal(){
        Basket basket = new Basket();

        addMult(basket, "BGLO", 2);
        addMult(basket, "BGLP", 12);
        addMult(basket, "BGLE", 6);
        addMult(basket, "COFB", 3);

        Reciept reciept = new Reciept(basket.getItems());

        Assertions.assertEquals("    ~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "    2021-03-16 21:38:44\n" +
                "\n" +
                "----------------------------\n" +
                "\n" +
                "Onion Bagel        2   £0.98\n" +
                "Plain Bagel        12  £3.99\n" +
                "Everything Bagel   6   £2.49\n" +
                "Coffee             3   £2.97\n" +
                "\n" +
                "----------------------------\n" +
                "Total                 £10.43\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!", reciept.getReciept());
    }
}
