package com.example.adoption;

public class Tips {
    private String Tips;
    private int image;
    private String name;


    public Tips(String tips, int image, String name ) {
        Tips = tips;
        this.image = image;
        this.name = name;
    }

    public String getTips() {
        return Tips;
    }

    public void setTips(String tips) {
        Tips = tips;
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
