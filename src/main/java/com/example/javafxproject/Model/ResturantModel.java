package com.example.javafxproject.Model;

public class ResturantModel {
    private int id;
    public static int Counts=0;
    public String getName() {
        return name;
    }
    private String name;
    public ResturantModel(String name) {

        this.id = ++Counts;
        this.name = name;
    }


}
