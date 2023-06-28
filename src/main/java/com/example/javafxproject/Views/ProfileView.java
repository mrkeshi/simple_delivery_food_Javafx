package com.example.javafxproject.Views;

import com.example.javafxproject.Model.OrderModel;
import com.example.javafxproject.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProfileView extends VBox {

    Componnet componnet=new Componnet();


public ProfileView(User user){

    Label name=componnet.label(user.getName(),20,"Black");
    Label username=componnet.label("@"+user.getUsername(),20,"Black");
    Label total=componnet.label("محصولات اضافه شده:"+ OrderModel.countFoodadded,20,"Black");
    this.setAlignment(Pos.CENTER);
    this.setPadding(new Insets(20));
    this.setSpacing(15);
    this.getChildren().addAll(name,username,total);
}

}

