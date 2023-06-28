package com.example.javafxproject.Views;

import com.example.javafxproject.Controller.FoodController;
import com.example.javafxproject.Model.FoodModel;
import com.example.javafxproject.Model.ResturantModel;
import com.example.javafxproject.SnapApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.Collection;

public class FoodsView extends VBox {
    Componnet componnet = new Componnet();
    public Button button;
    public Button deletedbutton;
    public Label countLAbel;

    public FoodsView Create(String name) {
        Rectangle square = new Rectangle(110, 100);
        square.setFill(Paint.valueOf("#05C0FF"));
        Label label = new Label(name);
        label.setFont(Font.font(SnapApp.FontG, FontWeight.MEDIUM, 17));
        label.setTextFill(Color.WHITE);
        StackPane.setAlignment(label, Pos.CENTER);
        this.setSpacing(10);
        StackPane stackPane = new StackPane(square, label);
        this.getChildren().add(stackPane);
        return this;
    }

    public VBox foodBox(Collection<FoodsView> foodsViews, ResturantModel res) {
        GridPane items = new GridPane();
        items.setMinWidth(SnapApp.witdh);
        int row = 1;
        int column = 1;
        int i = 0;
        for (FoodsView foo : foodsViews) {
            items.add(foo, column - 1, row - 1);
            i++;
            if (i % 3 == 0) {
                column = 0;
                row++;
            }
            column++;
        }
        items.setVgap(15);
        items.setHgap(15);
        items.setAlignment(Pos.CENTER);
        items.setPadding(new Insets(20));
        Label label = componnet.label(res.getName() + ":", 20, "Black");
        label.setPadding(new Insets(10));
        VBox vBox = new VBox(label, items);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    public VBox SingleFood(FoodModel foodModel) {
        button = componnet.button("add to cart", 20, "white", "#3DAA1F");
        deletedbutton = componnet.button("", 20, "red", "white");
        countLAbel = componnet.label("", 22, "#DB8819");
        HBox titlBox = new HBox(componnet.label("title:", 22, "#1F57B5"), componnet.label(foodModel.title, 20, "#DB8819"));
        HBox priceBox = new HBox(componnet.label("price:", 22, "#1F57B5"), componnet.label(String.valueOf(foodModel.Price), 20, "#DB8819"));
        HBox description = new HBox(componnet.label("description:", 22, "#1F57B5"), componnet.label(foodModel.description, 20, "#DB8819"));
        HBox ButtonBox = new HBox(button);
        HBox deletedbuttonbox = new HBox(deletedbutton);
        HBox countBox = new HBox(countLAbel);
        titlBox.setAlignment(Pos.CENTER);
        priceBox.setAlignment(Pos.CENTER);
        description.setAlignment(Pos.CENTER);
        ButtonBox.setAlignment(Pos.CENTER);
        deletedbuttonbox.setAlignment(Pos.CENTER);
        countBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(titlBox, priceBox, description, ButtonBox,deletedbuttonbox,countBox);
        vBox.setSpacing(20);
        VBox.setVgrow(vBox, Priority.ALWAYS);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
}
