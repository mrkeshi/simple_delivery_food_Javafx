package com.example.javafxproject.Controller;

import com.example.javafxproject.Model.OrderModel;
import com.example.javafxproject.Views.OrderView;

import java.util.ArrayList;

public class OrderController {
    OrderView orderView;
        public OrderController(ArrayList<OrderModel> orders){
            orderView=new OrderView(orders);
        }
    public OrderView getOrderViews(){
        return orderView ;
    }
}
