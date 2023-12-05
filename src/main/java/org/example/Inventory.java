package org.example;

public class Inventory {

    private Item compass;
    private Item walkieTalkie;
    private Item matches;
    private Item snake;
    private Item fish;
    private Item pen;
    protected Item[] items;

    public Inventory() {

        items = new Item[10];

        items[0] = compass = new Item("Compass");
        items[1] = walkieTalkie = new Item("Walkie-talkie");
        items[2] = matches = new Item("Matches");
        items[3] = snake = new Item("Snake");
        items[4] = fish = new Item("Fish");
        items[5] = pen = new Item("Pen");
    }
    public void setQuantity(int index, int quantity) {

        items[index].setQuantity(quantity);

    }

    public String getInventory(int index) {

        return items[index].getName();

    }

    public int getQuantity(int i) {

        return items[i].getQuantity();

    }
}

