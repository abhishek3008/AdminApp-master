package com.farmerskorner.adminapp;

public class Suggestion {

    private String imageText;
    private String name;
    private float rating;
    private String comment;

    public Suggestion(String imageText, String name, float rating, String comment) {
        this.imageText = imageText;
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    public String getImageText() {
        return imageText;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
