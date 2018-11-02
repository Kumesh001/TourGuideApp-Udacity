package com.example.jagat.tourguide.model;

import java.util.HashMap;

public class Museums {
    private String name,description,address,day;
    private int rating,open,close,type;
    private HashMap<Integer,int[]> days;

    public Museums(String name,String des,String address, int rating,int type,HashMap<Integer,int[]> days){
        this.name=name;
        this.description=des;
        this.address=address;
        this.days=days;
        this.rating=rating;
        this.type=type;
    }

    public int getType() {
        return type;
    }
    public void setType(int type){
        this.type=type;
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
