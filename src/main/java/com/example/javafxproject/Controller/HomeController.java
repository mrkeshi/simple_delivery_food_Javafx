package com.example.javafxproject.Controller;

import com.example.javafxproject.Model.ResturantModel;
import com.example.javafxproject.Model.User;
import com.example.javafxproject.Views.HomeView;
import com.example.javafxproject.Views.IndexView;
import com.example.javafxproject.Views.ResturantView;
import javafx.scene.layout.StackPane;
public class HomeController {
    User user;
    StackPane root;
    FoodController foodController;
    IndexController indexController;
    IndexView indexView;
    private HomeView homeView;
    public HomeController(User user, StackPane root, IndexController indexController, IndexView indexView) {
        this.indexView=indexView;
        this.indexController=indexController;
        this.user = user;
        this.root = root;
        homeView=new HomeView(user);
        foodController=new FoodController(homeView.getResturantController(),this);
        for (ResturantView view: homeView.getResturantController().getResturantsView()){
              view.setOnMouseClicked(MouseEvent->{
                  root.getChildren().removeAll();

                  ResturantModel model=homeView.getResturantController().find(view);

                  indexView.setCurrentPage(foodController.Food(model));
                  indexController.LoadView();
              });
        }
    }
    public HomeView getHomePage() {
        return homeView;
    }
}
