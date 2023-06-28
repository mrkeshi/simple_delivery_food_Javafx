package com.example.javafxproject.Controller;

import com.example.javafxproject.Model.User;
import com.example.javafxproject.Views.IndexView;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
public class IndexController {

    protected User user;
    private IndexView indexView;
    private int statusPage = 0;
    private StackPane root;
    private ProfileController profileController;
    private OrderController orderController;
    private HomeController homeController;
    private Label CurrentLabel;

    public IndexController(StackPane root, User user) {
        this.user = user;
        this.root = root;
        indexView = new IndexView(user);
        homeController = new HomeController(user, root, this, indexView);
        indexView.setCurrentPage(homeController.getHomePage());
        CurrentLabel = indexView.getHomeLabel();
    }
    public VBox LoadView() {
//        exit
        indexView.getExitLabel().setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });


//        go to profile view
        indexView.getProfileLabel().setOnMouseClicked(mouseEvent -> {
            profileController = new ProfileController(user, root);
            if (statusPage != 1) {
                statusPage = 1;
                root.getChildren().removeAll(root.getChildren());
                indexView.setCurrentPage(profileController.getProfileView());
                root.getChildren().add(indexView.LoadView());
                this.CurrentLabel.setTextFill(Paint.valueOf("#3366FF"));
                this.CurrentLabel = indexView.getProfileLabel();
                indexView.getHomeLabel().setTextFill(Paint.valueOf("#3366FF"));

                indexView.getProfileLabel().setTextFill(Paint.valueOf("RED"));
            }
        });

        //        go to profile view
        indexView.getProfile().setOnMouseClicked(mouseEvent -> {
            profileController = new ProfileController(user, root);

            if (statusPage != 1) {
                statusPage = 1;
                root.getChildren().removeAll(root.getChildren());
                indexView.setCurrentPage(profileController.getProfileView());
                root.getChildren().add(indexView.LoadView());
                this.CurrentLabel.setTextFill(Paint.valueOf("#3366FF"));
                this.CurrentLabel = indexView.getProfileLabel();
//                bag
                indexView.getHomeLabel().setTextFill(Paint.valueOf("#3366FF"));

                indexView.getProfileLabel().setTextFill(Paint.valueOf("RED"));
            }
        });


//        go to home
        indexView.getHomeLabel().setOnMouseClicked(mouseEvent -> {
            if (statusPage != 0) {
                statusPage = 0;
                root.getChildren().removeAll(root.getChildren());
                indexView.setCurrentPage(homeController.getHomePage());
                root.getChildren().add(indexView.LoadView());
                this.CurrentLabel.setTextFill(Paint.valueOf("#3366FF"));
                this.CurrentLabel = indexView.getHomeLabel();
                indexView.getHomeLabel().setTextFill(Paint.valueOf("RED"));
            }
        });

//        go to orders
        indexView.getOrdersLabel().setOnMouseClicked(mouseEvent -> {
            orderController = new OrderController(homeController.foodController.orderModels);
            if (statusPage != 2) {
                statusPage = 2;
                root.getChildren().removeAll(root.getChildren());
                indexView.setCurrentPage(orderController.getOrderViews());
                root.getChildren().add(indexView.LoadView());
                this.CurrentLabel.setTextFill(Paint.valueOf("#3366FF"));
                indexView.getHomeLabel().setTextFill(Paint.valueOf("#3366FF"));


                this.CurrentLabel = indexView.getOrdersLabel();
                indexView.getOrdersLabel().setTextFill(Paint.valueOf("RED"));
            }

        });

        return indexView.LoadView();

    }

}
