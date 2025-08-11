package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reciept {
    private Basket basket;

    public Reciept(Basket basket){
        this.basket = basket;
    }

    public String getReciept(){
        StringBuilder sb = new StringBuilder();

        sb.append("    ~~~ Bob's Bagels ~~~\n");
        sb.append("\n");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        sb.append(formattedDateTime);
        sb.append("\n");
        sb.append("\n");
        sb.append("----------------------------");
        sb.append("\n");
        int countStart = 19;
        int priceStart = 4;
        List<PriceInfo> priceInfo = basket.getPriceInfo();
        float acc = 0;
        for(PriceInfo curr : priceInfo){
            sb.append(curr.getName());
            sb.append(blankSpace(curr.getName(), countStart));
            sb.append(curr.getCount());
            sb.append(blankSpace(String.valueOf(curr.getCount()), priceStart));
            sb.append("£");
            sb.append(curr.getCost());
            sb.append("\n");
            acc += curr.getCost();
        }
        sb.append("\n");
        sb.append("----------------------------\n");
        sb.append("Total");
        sb.append(blankSpace("Total", countStart+priceStart));
        sb.append(String.format( "£%.2f", acc));

        return sb.toString();
    }

    public String blankSpace(String nameVar, int startIndex){
        int offset = startIndex-nameVar.length();

        StringBuilder sb = new StringBuilder();
        sb.repeat(" ", offset);
        return sb.toString();
    }

}
