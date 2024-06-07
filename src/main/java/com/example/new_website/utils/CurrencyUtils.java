package com.example.new_website.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyUtils {

    public static String formatCurrency(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("vi", "VN"));
        symbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);
        return formatter.format(amount) + " VND";
    }
}

