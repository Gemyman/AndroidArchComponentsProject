package com.ex.androidarchcomponentsproject.models;

public class DataModel {
    private Items[] items;

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ClassPojo [items = " + items + "]";
    }
}
