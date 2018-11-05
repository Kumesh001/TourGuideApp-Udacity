package com.example.jagat.tourguide.model;

import java.util.HashMap;

public class Monument {
    public String name,description;
    public int rating;
    public int thumbnail=0;
    public HashMap<String, int[]> days;
    private int open,close;
    private String day;

    public Monument(String name,String des,int rating, int thumbnail,HashMap<String,int[]> days)
    {
        this.name=name;
        this.description=des;
        this.rating=rating;
        this.thumbnail=thumbnail;
        this.days=days;
    }

    public Monument(String name,int rating,int thumbnail,HashMap<String,int[]> days)
    {
        this.name=name;
        this.rating=rating;
        this.thumbnail=thumbnail;
        this.days=days;
        this.description="";
    }

    // Will deal with the later
    public int getOpen() {
        return open;
    }

    public int getClose() {
        return close;
    }

    public String getDay() {
        return day;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setDays(HashMap<String, int[]> days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public HashMap<String, int[]> getDays() {
        return days;
    }
}
