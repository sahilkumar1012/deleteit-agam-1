package com.example.deleteitagam.entity;

public class SushiItem{
    private int seatId;
    private String menuItemId;

    public SushiItem(int seatId, String menuItemId) {
        this.seatId = seatId;
        this.menuItemId = menuItemId;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public String toString(){
        return null;
    }

    @Override
    public boolean equals(Object o){
        return false;
    }

}
