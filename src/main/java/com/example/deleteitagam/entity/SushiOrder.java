package com.example.deleteitagam.entity;

import java.util.ArrayList;

public class SushiOrder {

    private int seatId;
    private ArrayList<String> menuItemIds;

    public SushiOrder(int seatId, ArrayList<String> menuItemIds) {
        this.seatId = seatId;
        this.menuItemIds = menuItemIds;
    }

    public int getSeatId() {
        return seatId;
    }

    public ArrayList<String> getMenuItemIds() {
        return menuItemIds;
    }
    public String toString(){
        return menuItemIds.toString();
    }
}
