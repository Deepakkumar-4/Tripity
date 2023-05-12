package com.example.tripity.Fragments;

public class ArchaeologyPlace {

    String name;
    String location;
    int imageUrl;
    String Description;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

