package com.poly.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class DB {
    public static Map<Integer, Item> items = new LinkedHashMap<>();

    static {
        items.put(1, new Item(1, "Laptop", 1500.0, 1));
        items.put(2, new Item(2, "Phone", 800.0, 1));
        items.put(3, new Item(3, "Headphones", 150.0, 1));
    }
}
