package com.example.listviewwithprojecttwo;

public class User {

    private String name;
    private String lastMsg;
    private String lastMsgTime;
    private String phoneNumber;
    private int imageId;

    // Constructor
    public User(String name, String lastMsg, String lastMsgTime, String phoneNumber, int imageId) {
        this.name = name;
        this.lastMsg = lastMsg;
        this.lastMsgTime = lastMsgTime;
        this.phoneNumber = phoneNumber;
        this.imageId = imageId;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(String lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}