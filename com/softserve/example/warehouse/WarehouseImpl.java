package com.softserve.example.warehouse;

import java.util.HashMap;

public class WarehouseImpl implements Warehouse {
    private HashMap<String, Integer> dataStorage = new HashMap<String, Integer>();

    @Override
    public void add(String name, int quantity) {
        int currQuantity = 0;
        if (dataStorage.containsKey(name)) {
            currQuantity = dataStorage.get(name);
        }
        dataStorage.put(name, quantity + currQuantity);
    }

    @Override
    public int getInventory(String name) {
        return dataStorage.get(name);
    }

    @Override
    public void removeInventory(String name, int quantity) {
        if (dataStorage.containsKey(name)) {
            Integer storedQuantity = dataStorage.get(name);
            if (storedQuantity >= quantity) {
                dataStorage.put(name, storedQuantity - quantity);
            }
        }
    }
}
