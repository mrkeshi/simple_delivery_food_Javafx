package com.example.javafxproject.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FoodModel {
    public int counts = 0;

    public FoodModel(String title, int price, ResturantModel isRestorant, String description) {
        this.title = title;
        Price = price;
        this.isRestorant = isRestorant;
        this.description = description;
        ++counts;
        this.id = counts;
    }
    @Override
    protected void finalize() throws Throwable {
        --counts;
    }
    public int id;
    public String title;
    public int Price;
    public IntegerProperty getPrice() {
        return new SimpleIntegerProperty(Price);
    }
    public ResturantModel isRestorant;
    public String description;

}
