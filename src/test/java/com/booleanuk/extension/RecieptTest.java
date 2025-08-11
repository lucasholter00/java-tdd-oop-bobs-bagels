package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class RecieptTest {

    public boolean addMult(Basket basket, String sku, int times){
        if(times == 0){
            return true;
        }

        return basket.add(sku) == 1 && addMult(basket, sku, times-1);
    }

    @Test
    public void testPrintRecieptNormal(){

        Stock stock = new Stock();

        Map<String, Integer> map = Map.of(
                "BGLO", 2,
                "BGLP", 12,
                "BGLE", 6,
                "COFB", 3
        );

        Reciept reciept = new Reciept(map, stock);

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
