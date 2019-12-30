package com.example.sarashpaz.model;

public class Foods {
    private String name;
    private int image;
    public Foods() {
    }

    public Foods(String name) {
        this.name = name;
    }

    public Foods(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
