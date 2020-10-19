package com.example.adoption;

public class Animal {
    private String animalName;
    private String ImageUrl;
//    private String mfullName;

//    private int Age;

    public Animal(String animalName, String imageUrl) {
        this.animalName = animalName;
        ImageUrl = imageUrl;
//        this.mfullName = mfullName;
//        Age = age;
    }

    public Animal() {
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

//    public String getMfullName() {
//        return mfullName;
//    }
//
//    public void setMfullName(String mfullName) {
//        this.mfullName = mfullName;
//    }

    //    public int getAge() {
//        return Age;
////    }
//
//    public void setAge(int age) {
//        Age = age;
//    }
}
