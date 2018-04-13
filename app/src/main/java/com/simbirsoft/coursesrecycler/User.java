package com.simbirsoft.coursesrecycler;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String name;
    public String email;
    public String phone;
    public double latitude;
    public double longitude;

    public User() {

    }

    public User(String name,String email, String phone, double latitude, double longitude) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //...
}
