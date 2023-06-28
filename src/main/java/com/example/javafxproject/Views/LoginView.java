package com.example.javafxproject.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {
    public Componnet componnet=new Componnet();
    public Label message=componnet.label("error to login",15,"red");
    private TextField UserName= componnet.Input();
    private TextField Password= componnet.Input();
    public VBox getLinkToRegister() {
        return LinkToRegister;
    }
    private VBox LinkToRegister=new VBox();
    private Button LoginBtn= componnet.button("Login",17,"white","#1939B7");

public LoginView(){
    Label userNameLabel=componnet.label("username",17,"Black");
    Label passwordLabel=componnet.label("password",17,"Black");
    message.setAlignment(Pos.CENTER);
    LoginBtn.setMinHeight(40);
    LoginBtn.setMinWidth(130);
    VBox rbox=new VBox(LoginBtn);
    rbox.setPadding(new Insets(10,0,0,0));
    LinkToRegister.getChildren().add(componnet.label("click to Register",14,"#1939B7"));
    LinkToRegister.setAlignment(Pos.CENTER);
    this.setPadding(new Insets(15));
    this.setSpacing(12);
    this.getChildren().addAll(userNameLabel,UserName,passwordLabel,Password,rbox,LinkToRegister);
}
    public String getUserName() {
        return UserName.getText();
    }
    public Label getMessage() {
        return message;
    }
    public String getPassword() {
        return Password.getText();
    }
    public Button getLoginBtn() {
        return LoginBtn;
    }
}
