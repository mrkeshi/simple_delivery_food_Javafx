package com.example.javafxproject.Controller;

import com.example.javafxproject.Model.User;
import com.example.javafxproject.Views.LoginView;
import com.example.javafxproject.Views.RegisterView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

public class UserController {
    private RegisterView registerView = new RegisterView();
    private User user=new User();


    private LoginView loginView = new LoginView();

    public UserController(StackPane root){

        loginView.getLinkToRegister().setOnMouseClicked(mouseEvent -> {
        root.getChildren().remove(loginView);
        root.getChildren().add(getRegisterView());


        });
        registerView.getLinkToLogin().setOnMouseClicked(mouseEvent -> {
            root.getChildren().remove(registerView);
            root.getChildren().add(getLoginView());

        });
        loginView.getLoginBtn().setOnAction(moseEvent->{
            if(!user.login(loginView.getUserName(),loginView.getPassword())){
                if (!loginView.getChildren().contains(loginView.getMessage())) {loginView.getChildren().add(loginView.getMessage());};
            }else{
                root.getChildren().remove(loginView);
                IndexController index=new IndexController(root,user);

                root.getChildren().add(index.LoadView());
                root.setBackground(Background.fill(Paint.valueOf("#fff")));
            }
        });

    }

    public RegisterView getRegisterView() {
        return registerView;
    }
    public LoginView getLoginView() {
        return loginView;
    }

}
