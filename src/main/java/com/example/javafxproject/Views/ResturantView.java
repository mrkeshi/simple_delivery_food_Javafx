package com.example.javafxproject.Views;
import com.example.javafxproject.SnapApp;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ResturantView extends VBox {

    public ResturantView(String name){
        Rectangle square = new Rectangle(110, 100);
        square.setFill(Paint.valueOf("#1939B7"));
        Label label = new Label(name);
        label.setFont(Font.font(SnapApp.FontG, FontWeight.MEDIUM,17));
        label.setTextFill(Color.WHITE);
        StackPane.setAlignment(label, Pos.CENTER);
        this.setSpacing(10);
        StackPane stackPane = new StackPane(square, label);
        this.getChildren().add(stackPane);
    }
}
