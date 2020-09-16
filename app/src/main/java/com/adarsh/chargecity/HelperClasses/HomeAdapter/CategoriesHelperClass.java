package com.adarsh.chargecity.HelperClasses.HomeAdapter;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
    GradientDrawable gradient;
    int image;
    String title;

    public CategoriesHelperClass(GradientDrawable gradient, int image, String title) {
        this.image = image;
        this.title = title;
        this. gradient = gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getGradient() {
        return gradient;
    }
}




