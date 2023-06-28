package com.example.javafxproject.Controller;
import com.example.javafxproject.Model.FoodModel;
import com.example.javafxproject.Model.OrderModel;
import com.example.javafxproject.Model.ResturantModel;
import com.example.javafxproject.Views.FoodsView;
import javafx.scene.layout.VBox;

import java.util.*;
public class FoodController {
    ResturantController resturantController;
    public static ArrayList<OrderModel> orderModels = new ArrayList<>();
    public FoodModel foodModel;
    public FoodsView foodsView;
    public HomeController homeController;
    public ArrayList<FoodsView> FoodsPageCurrent = new ArrayList<>();
    public HashMap<FoodModel, FoodsView> FoodList = new HashMap<>();
    public OrderModel or;
    public FoodController(ResturantController resturantController, HomeController homeController) {
        this.homeController = homeController;
        this.resturantController = resturantController;

        //        insert Fake Data
        for (ResturantModel res : resturantController.getResturant()) {
            Create("moz" + res.getName().split(" ")[1], new Random().nextInt(1000)+1000 , res, "descriptonn..." );
            Create("Gosht" + res.getName().split(" ")[1], new Random().nextInt(500)+1000, res, "descriptonn..." );
        }
    }
    public void Create(String title, int price, ResturantModel resturantModel, String description) {
        this.foodModel = new FoodModel(title, price, resturantModel, description);
        this.foodsView = new FoodsView().Create(title);
        FoodList.put(this.foodModel, this.foodsView);
    }
    public Collection<FoodsView> getFoodsViews(ResturantModel res) {
        FoodsPageCurrent.removeAll(FoodsPageCurrent);
        for (FoodModel food : FoodList.keySet()) {
            if (food.isRestorant == res || food.isRestorant.equals(res)) {
                FoodsPageCurrent.add(FoodList.get(food));
            }
        }
        for (FoodsView food : FoodsPageCurrent) {
            food.setOnMouseClicked(MouseEvent -> {
                homeController.root.getChildren().removeAll();
                homeController.indexView.setCurrentPage(foodsView.SingleFood(this.find(food)));
                homeController.indexController.LoadView();
                foodsView.button.setOnAction(actionEvent -> {
                    ResturantModel resturantMod = this.find(food).isRestorant;
                    or=new OrderModel(resturantMod, this.find(food));

                    orderModels.add(or);
                    System.out.println(or.foodModel.title + ": added");
                    if(orderModels.contains(or)){
                       foodsView.deletedbutton.setText("remove all");
                        foodsView.countLAbel.setText("count in cart:"+ Collections.frequency(orderModels,or));
                    }else {
                        foodsView.deletedbutton.setText("");
                        foodsView.countLAbel.setText("");
                    }
                });
                if(OrderModel.Count(this.find(food),orderModels)>0){
                    foodsView.deletedbutton.setText("remove all");
                    foodsView.countLAbel.setText("count in cart:"+ OrderModel.Count(this.find(food),orderModels));
                }else {
                    foodsView.deletedbutton.setText("");
                    foodsView.countLAbel.setText("");
                }
                foodsView.deletedbutton.setOnAction(actionEvent -> {
                    foodsView.countLAbel.setText("");
                    foodsView.deletedbutton.setText("");
                    OrderModel.removeAll(this.find(food),orderModels);
                });
            });
        }
        return FoodsPageCurrent;
    }
    public VBox Food(ResturantModel res) {

        return new FoodsView().foodBox(this.getFoodsViews(res), res);
    }
    public FoodModel find(FoodsView foodsView) {

        for (FoodModel r : FoodList.keySet()) {
            if (Objects.equals(FoodList.get(r), foodsView)) {

                return r;
            }
        }
        return null;
    }
}
