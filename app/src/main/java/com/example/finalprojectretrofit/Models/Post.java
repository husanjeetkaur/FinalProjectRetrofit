package com.example.finalprojectretrofit.Models;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("Email")
    private String email;

    @SerializedName("Password")
    private int password;

    public Post(String email, int password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
