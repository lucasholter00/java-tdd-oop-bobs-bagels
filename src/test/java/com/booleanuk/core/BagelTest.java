package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void testAddAndRemoveFilling(){
        Bagel bagel = new Bagel("BGLO", 0.49f, "Onion");
        Filling filling = new Filling("FILB", 0.12f, "Bacon");

        Assertions.assertTrue(bagel.getFillings().isEmpty());

        bagel.addFilling(filling);

        Assertions.assertEquals(1, bagel.getFillings().size());

        bagel.removeFilling("Bacon");

        Assertions.assertTrue(bagel.getFillings().isEmpty());
    }

}
