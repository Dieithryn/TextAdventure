package org.example;

public class Inventory {

    private Item compass;
    private Item walkieTalkie;
    private Item matches;
    protected Item[] items;

    public Inventory() {

        items = new Item[5];

    }

    public String getInventory(int i) {

        return items[i].getName();

    }

    public int getQuantity(int i) {


        return items[i].getQuantity();

    }
}

