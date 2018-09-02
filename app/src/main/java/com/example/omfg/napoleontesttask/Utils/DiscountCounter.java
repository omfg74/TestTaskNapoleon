package com.example.omfg.napoleontesttask.Utils;

public class DiscountCounter {
    public String count(int price, Double discount){
        int newPrice = (int) (price*discount);
        return String.valueOf(newPrice);
    }
}
