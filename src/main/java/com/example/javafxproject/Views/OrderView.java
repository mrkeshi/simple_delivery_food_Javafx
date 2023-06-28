package com.example.javafxproject.Views;

import com.example.javafxproject.Model.OrderModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class OrderView extends VBox {
    public TableView<OrderModel> tableView;
    public int Prices = 0;

    Componnet componnet = new Componnet();


    public OrderView(ArrayList<OrderModel> orders) {
        Label title = componnet.label("Shopping cart list", 24, "Black");

        this.tableView = new TableView<>();

        TableColumn<OrderModel, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(st -> new SimpleStringProperty(st.getValue().foodModel.title));

        TableColumn<OrderModel, Integer> priceColumn = new TableColumn<>("price");
        priceColumn.setCellValueFactory(st2 -> st2.getValue().foodModel.getPrice().asObject());
        TableColumn<OrderModel, String> resturanname = new TableColumn<>("restaurant");
        resturanname.setCellValueFactory(st3 -> new SimpleStringProperty(st3.getValue().foodModel.isRestorant.getName()));

        for (OrderModel orderModel : orders) {
            tableView.getItems().add(orderModel);
            Prices += orderModel.foodModel.Price;
        }

        tableView.getColumns().addAll(nameColumn, priceColumn, resturanname);

        Button delete = componnet.button("delete selected", 18, "white", "#D82E28");
        Label labelprice = componnet.label("total price:" + Prices, 18, "Red");

        delete.setOnAction(MouseEvent -> {

            OrderModel order = tableView.getSelectionModel().getSelectedItem();
            if (order != null) {
                System.out.println(orders.size());
                tableView.getItems().remove(order);
                orders.remove(order);
                OrderModel.countFoodadded--;
                this.Prices -= order.foodModel.Price;
                labelprice.setText("total price:" + Prices);

            }

        });
        this.setPadding(new Insets(10));
        this.setSpacing(5);
        this.getChildren().addAll(title, tableView, delete, labelprice);
    }
}
