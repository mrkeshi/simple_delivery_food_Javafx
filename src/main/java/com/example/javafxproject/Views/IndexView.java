package com.example.javafxproject.Views;
import com.example.javafxproject.Model.User;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class IndexView extends VBox {

    public User user;
    public Componnet componnet = new Componnet();
    public HBox header;

    public Label getHomeLabel() {
        return homeLabel;
    }

    public Label getOrdersLabel() {
        return ordersLabel;
    }

    public Label getProfileLabel() {
        return profileLabel;
    }

    public Label getExitLabel() {
        return exitLabel;
    }
    public Label getProfile() {
        return profile;
    }
    public VBox getCurrentPage() {
        return CurrentPage;
    }
    private Label homeLabel = componnet.label("Home", 18, "#3366FF");
    private Label ordersLabel = componnet.label("Order", 18, "#3366FF");
    private Label profileLabel = componnet.label("Profile", 18, "#3366FF");
    private Label exitLabel = componnet.label("Exit", 18, "#3366FF");
    private Label profile = new Label("Profile");
    public void setCurrentPage(VBox currentPage) {
        CurrentPage = currentPage;
    }
    public VBox CurrentPage;
    public IndexView(User user) {
        this.user = user;
    }

    public IndexView LoadView() {

        this.getChildren().removeAll(this.getChildren());
        this.header = componnet.Navbar(user.getName(), profile);
        this.getChildren().add(header);
        this.getChildren().add(getCurrentPage());
        this.getChildren().add(componnet.Footer(homeLabel, ordersLabel, profileLabel, exitLabel));

        return this;
    }
}
