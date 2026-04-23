package com.example.recycleview;

public class News {

    private String newsHeading;
    private int newsImage;
    private String newsContent;

    // Constructor
    public News(String newsHeading, int newsImage, String newsContent) {
        this.newsHeading = newsHeading;
        this.newsImage = newsImage;
        this.newsContent = newsContent;
    }

    // Getters
    public String getNewsHeading() {
        return newsHeading;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public String getNewsContent() {
        return newsContent;
    }

    // Setters
    public void setNewsHeading(String newsHeading) {
        this.newsHeading = newsHeading;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}