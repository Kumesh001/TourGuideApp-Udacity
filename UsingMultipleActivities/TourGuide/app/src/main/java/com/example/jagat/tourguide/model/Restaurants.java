package com.example.jagat.tourguide.model;

import java.util.HashMap;

public class Restaurants {
    private String name,description,address,day;
    private int rating,open,close;
    private HashMap<Integer,int[]> days;

    public Restaurants(String name,String des,String address, int rating,HashMap<Integer,int[]> days){
        this.name=name;
        this.description=des;
        this.address=address;
        this.days=days;
        this.rating=rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getDay() {
        return day;
    }

    public int getRating() {
        return rating;
    }

    public int getOpen() {
        return open;
    }

    public int getClose() {
        return close;
    }

    public HashMap<Integer, int[]> getDays() {
        return days;
    }

}
