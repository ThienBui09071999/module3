package com.example.user_management.model;

public class Country {
    protected int id;
    protected String name;

    public Country() {
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Country(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
