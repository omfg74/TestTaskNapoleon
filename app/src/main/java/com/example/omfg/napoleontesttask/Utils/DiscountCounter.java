package com.example.omfg.napoleontesttask.Utils;

public class DiscountCounter {
    //рассчет цены
    public String count(int price, Double discount){
        int newPrice = (int) (price*discount);
        return String.valueOf(newPrice);
    }
}
