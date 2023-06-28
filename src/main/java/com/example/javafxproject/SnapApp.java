package com.example.javafxproject;

import com.example.javafxproject.Controller.UserController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SnapApp extends Application {
    public static String FontG="Verdana";

    public final static int witdh = 400;
    public final static int height = 600;

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, witdh, height);
        stage.setResizable(false);
        root.setBackground(Background.fill(Paint.valueOf("#85a57c")));
        stage.setTitle("Food");

        root.getChildren().add(new UserController(root).getLoginView());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
