package com.example.javafxproject.Controller;

import com.example.javafxproject.Model.User;
import com.example.javafxproject.Views.ProfileView;
import javafx.scene.layout.StackPane;

public class ProfileController  {

    private ProfileView profileView;
    public ProfileController(User user,StackPane root){
    profileView=new ProfileView(user);
    }
    public ProfileView getProfileView() {
        return profileView;
    }

}
