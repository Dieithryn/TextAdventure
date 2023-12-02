package org.example;

public class Inventory {
    protected String[][] items;

    public Inventory() {

        items = new String[5][2];

    }

    public String getInventory(int i) {

        return items[i][0] + " " + items[i][1];

    }

    public int getQuantity(int i) {

        int quantity = Integer.parseInt(items[i][1]);
        return quantity;

    }


    public void setInventory (String item, int i) {

            items[i][0] = item;

    }

    public void setQuantity (int quantity, int i) {

            items[i][1] = Integer.toString(quantity);

    }
}

