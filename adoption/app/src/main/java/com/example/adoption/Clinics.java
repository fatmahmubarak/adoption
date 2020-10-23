package com.example.adoption;

public class Clinics {
    private String name;
    private String phone;
    private int image;
    private String Map;

    public Clinics(String name, String phone, int image, String Map) {
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.Map = Map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMap() {
        return Map;
    }

    public void setMap(String map) {
        Map = map;
    }
}
