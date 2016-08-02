package com.softserve.example.warehouse;

public class Order {
    private String name;
    private int quantity;
    private boolean filled;

    public Order (String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void fill(Warehouse warehouse) {
        if (warehouse.getInventory(name) >= quantity) {
            warehouse.removeInventory(name, quantity);
            filled = true;
        }
    }

    public boolean isFilled() {
        return filled;
    }

}
