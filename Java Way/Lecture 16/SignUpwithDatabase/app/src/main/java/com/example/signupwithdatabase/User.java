package com.example.signupwithdatabase;

public class User {

    private String name;
    private String email;
    private String password;
    private String uniqueId;

    // Empty constructor (IMPORTANT for Firebase)
    public User() {
    }

    // Parameterized constructor
    public User(String name, String email, String password, String uniqueId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.uniqueId = uniqueId;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}