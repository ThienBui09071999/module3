package com.example.displaycustomer.model;

public class Customer {
    private String name;
    private String dateBorn;
    private String address;
    private String urlPhoto;

    public Customer() {
    }

    public Customer(String name, String dateBorn, String address, String urlPhoto) {
        this.name = name;
        this.dateBorn = dateBorn;
        this.address = address;
        this.urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

}
