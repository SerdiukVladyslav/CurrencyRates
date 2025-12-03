package com.example.currencyrates;

import java.util.ArrayList;

public class FilterHelper {

    public static ArrayList<String> filter(ArrayList<String> input, String text) {
        ArrayList<String> filtered = new ArrayList<>();

        for (String item : input) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filtered.add(item);
            }
        }

        return filtered;
    }
}
