package com.example.javafxproject.Views;

import com.example.javafxproject.SnapApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.DropShadow;

public class Componnet {

    public Font font = Font.font("Verdana", FontWeight.MEDIUM, 16);

    public TextField Input() {
        TextField ali = new TextField();
        ali.setMinHeight(45);
        ali.setMaxHeight(45);
        ali.setFont(font);

        return ali;
    }

    public Label label(String title, int size, String color) {
        Label label = new Label(title);
        label.setTextFill(Paint.valueOf(color));
        label.setFont(Font.font(SnapApp.FontG, FontWeight.MEDIUM, size));
        return label;
    }

    public Button button(String title, int size, String color, String background) {
        Button button = new Button(title);
        button.setTextFill(Paint.valueOf(color));
        button.setFont(Font.font(SnapApp.FontG, size));
        button.setBackground(Background.fill(Paint.valueOf(background)));
        return button;
    }

    public HBox Navbar(String name,Label prof) {
        HBox header = new HBox();
        header.setMinWidth(SnapApp.witdh);
        header.setMinHeight(60);
        header.setBackground(Background.fill(Paint.valueOf("#3366FF")));
        Label title = new Label("hi! ," + name);
        VBox titleVbox = new VBox(title);
        titleVbox.setAlignment(Pos.CENTER_LEFT);
        title.setFont(Font.font(SnapApp.FontG, FontWeight.MEDIUM, 15));
        title.setTextFill(Paint.valueOf("#D6E4FF"));
        prof.setFont(Font.font(SnapApp.FontG, FontWeight.BOLD, 16));
        prof.setTextFill(Paint.valueOf("#D6E4FF"));
        VBox profVob = new VBox(prof);
        profVob.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(profVob, Priority.ALWAYS);
        header.getChildren().add(titleVbox);
        header.getChildren().add(profVob);
        header.setEffect(new DropShadow(10, Color.GRAY));
        header.setPadding(new Insets(8));
        return header;
    }

    public GridPane Footer(Label homeLabel,Label ordersLabel,Label profileLabel,Label exitLabel) {

        GridPane menuBar = new GridPane();
        menuBar.setMinWidth(SnapApp.witdh);

        homeLabel.setTextFill(Paint.valueOf("RED"));

        menuBar.addRow(0, homeLabel);
        menuBar.addRow(0, ordersLabel);
        menuBar.addRow(0, profileLabel);
        menuBar.addRow(0, exitLabel);
        VBox.setVgrow(menuBar,Priority.ALWAYS);
        menuBar.setHgap(45);
        menuBar.setVgap(30);
        menuBar.setAlignment(Pos.BOTTOM_CENTER);
        menuBar.setMinHeight(100);
        menuBar.setPadding(new Insets(15));

        return menuBar;
    }


}
