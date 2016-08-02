package com.softserve.example.warehouse;

public interface Warehouse {
    void add(String name, int quantity);

    int getInventory(String name);

    void removeInventory(String name, int quantity);
}
