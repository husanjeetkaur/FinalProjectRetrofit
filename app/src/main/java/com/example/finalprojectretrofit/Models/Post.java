package com.example.finalprojectretrofit.Models;

public class Post {


    private String Email;
    private int Password;

    public Post(String email, int password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
