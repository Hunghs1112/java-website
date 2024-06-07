package com.example.new_website.utils;



import java.text.DecimalFormat;

public class CurrencyUtils {

    public static String formatCurrency(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount) + " VND";
    }
}
