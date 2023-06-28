package com.example.javafxproject.Controller;
import com.example.javafxproject.Model.ResturantModel;
import com.example.javafxproject.Views.ResturantView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResturantController {
    ResturantView resturantView;
    ResturantModel resturantModel;
    Map<ResturantModel, ResturantView> ResturantList = new HashMap<>();
    public ResturantController() {
        this.Create("resturant A");
        this.Create("resturant B");
        this.Create("resturant C");
        this.Create("resturant D");
        this.Create("resturant E");
    }
    public void Create(String name) {
        resturantModel = new ResturantModel(name);
        resturantView = new ResturantView(name);
        ResturantList.put(resturantModel,resturantView);
    }
    public Collection<ResturantModel> getResturant() {
        return ResturantList.keySet();
    }
    public Collection<ResturantView> getResturantsView(){
        return ResturantList.values();
    }
public ResturantModel find(ResturantView resturantView){

    for (ResturantModel r : ResturantList.keySet()) {
        if (Objects.equals(ResturantList.get(r), resturantView)) {

            return r;
        }
    }
    return null;
    }
}
