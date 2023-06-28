package com.example.javafxproject.Model;

public class User {


    public boolean login(String user, String password) {
        if (user.equals("alireza") && password.equals("1234")) {


        this.Name = "Alireza";
        this.Username = "Pares28";
        return true;}
        return false;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Name;
    private String Username;
    private String Password;

}
