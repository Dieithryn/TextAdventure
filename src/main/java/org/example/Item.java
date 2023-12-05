package org.example;

public class Item {

    private String name;
    private int quantity;
    public Item(String name) {

        this.name = name;
        this.quantity = 0;

    }
    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }
    public int getQuantity() {

        return quantity;

    }
    public String getName() {

        return name;

    }

}
