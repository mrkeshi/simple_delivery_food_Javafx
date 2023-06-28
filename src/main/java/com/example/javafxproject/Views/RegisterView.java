package com.example.javafxproject.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class RegisterView extends VBox {
    public Componnet componnet=new Componnet();

    public String getName() {
        return Name.getText();
    }



    private TextField Name= componnet.Input();
    private TextField UserName= componnet.Input();
    private TextField Password= componnet.Input();

    public VBox getLinkToLogin() {
        return LinkToLogin;
    }

    private VBox LinkToLogin=new VBox();
    public Button getRegisterBtn() {
        return RegisterBtn;
    }

    private Button RegisterBtn= componnet.button("Register",17,"white","#1939B7");


public RegisterView(){
    Label nameLabel=componnet.label("name",17,"Black");
    Label userNameLabel=componnet.label("username",17,"Black");
    Label passwordLabel=componnet.label("password",17,"Black");


    RegisterBtn.setMinHeight(40);
    RegisterBtn.setMinWidth(130);
    VBox rbox=new VBox(RegisterBtn);
    rbox.setPadding(new Insets(10,0,0,0));

    LinkToLogin.getChildren().add(componnet.label("click to Login!",14,"#1939B7"));
    LinkToLogin.setAlignment(Pos.CENTER);

    this.setPadding(new Insets(15));
    this.setSpacing(12);
    this.getChildren().addAll(nameLabel,Name,userNameLabel,UserName,passwordLabel,Password,rbox,LinkToLogin);

//    this.setBackground(Background.fill(Paint.valueOf("Yellow")));
}


}
