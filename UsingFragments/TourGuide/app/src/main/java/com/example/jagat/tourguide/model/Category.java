package com.example.jagat.tourguide.model;

public class Category {
    private String mTitle;
    private int mThumbnail;

    public Category(){

    }
    public Category(String title,int thumbnail)
    {
        this.mTitle=title;
        this.mThumbnail=thumbnail;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setThumbnail(int mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getThumbnail() {
        return mThumbnail;
    }
}
