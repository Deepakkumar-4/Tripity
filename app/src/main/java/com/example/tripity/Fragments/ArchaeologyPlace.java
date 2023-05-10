package com.example.tripity.Fragments;

public class ArchaeologyPlace {

    private String name;
    private String location;
    private int imageUrl;
    private String Description;

    public ArchaeologyPlace(String name, String location, int imageUrl, String description) {
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
        this.Description = description;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return Description;
    }
}

