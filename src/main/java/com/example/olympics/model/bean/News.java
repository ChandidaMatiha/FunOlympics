package com.example.olympics.model.bean;

public class News {
    String id, newsTitle,date,context,image;

    public News(String id, String newsTitle, String date, String context, String image) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.date = date;
        this.context = context;
        this.image = image;
    }

    public News() {
    }

    public News(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
