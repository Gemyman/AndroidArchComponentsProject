package com.ex.androidarchcomponentsproject.models;

import java.util.ArrayList;

import io.realm.RealmObject;

public class DataModel  {
    private ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ClassPojo [items = " + items + "]";
    }
}
