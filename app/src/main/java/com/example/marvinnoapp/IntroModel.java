package com.example.marvinnoapp;

public class IntroModel {
    String heading, subheading;
    int img;

    public IntroModel(String heading, String subheading, int img) {
        this.heading = heading;
        this.subheading = subheading;
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
