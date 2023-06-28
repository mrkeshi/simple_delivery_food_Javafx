package com.example.javafxproject.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class OrderModel {
    public static int countFoodadded;

    public OrderModel(ResturantModel resturantModel, FoodModel foodModel) {
        this.resturantModel = resturantModel;
        this.foodModel = foodModel;
            countFoodadded++;

    }




    public ResturantModel resturantModel;
    public FoodModel foodModel;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderModel other = (OrderModel) obj;
        return Objects.equals(resturantModel, other.resturantModel) &&
                Objects.equals(foodModel, other.foodModel);
    }
    public static void removeAll(FoodModel foodModel, ArrayList<OrderModel> orderModels) {
        Iterator<OrderModel> iterator = orderModels.iterator();
        while (iterator.hasNext()) {
            OrderModel.countFoodadded--;

            OrderModel order = iterator.next();
            if (order.foodModel.equals(foodModel) || order.foodModel == foodModel) {
                iterator.remove();
            }
        }

    }
    public static int Count(FoodModel foodModel, ArrayList<OrderModel> orderModels) {
        int ali=0;
        Iterator<OrderModel> iterator = orderModels.iterator();
        while (iterator.hasNext()) {
            OrderModel order = iterator.next();
            if (order.foodModel.equals(foodModel) || order.foodModel == foodModel) {
            ++ali;
            }
        }
        return ali;

    }
}
