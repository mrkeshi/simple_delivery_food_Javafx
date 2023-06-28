package com.example.javafxproject.Views;

import com.example.javafxproject.Controller.ResturantController;
import com.example.javafxproject.Model.User;
import com.example.javafxproject.SnapApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Collection;
public class HomeView extends VBox {
    public ResturantController getResturantController() {
        return resturantController;
    }
    ResturantController resturantController = new ResturantController();
    public HomeView(User user) {

        GridPane items = new GridPane();
        items.setMinWidth(SnapApp.witdh);
        Collection<ResturantView> resturantView = resturantController.getResturantsView();
        int row = 1;
        int column =1;
        int i=0;
        for (ResturantView res:resturantView){
            items.add(res,column-1,row-1);
            i++;
            if (i%3==0){
                column=0;
                row++;
            }
                column++;
        }
        items.setVgap(15);
        items.setHgap(15);
        items.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(items);
        items.setPadding(new Insets(20));
    }

}
