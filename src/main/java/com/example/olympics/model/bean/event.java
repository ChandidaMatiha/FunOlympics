package com.example.olympics.model.bean;

public class event {
    String id, eventTitle,date,location,context,image;
    String day,dayNum,year;
    public event(String id, String eventTitle, String date, String location, String context, String image) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.date = date;
        this.location = location;
        this.context = context;
        this.image = image;
    }

    public event(String id, String eventTitle, String date, String location, String context, String image, String day, String dayNum, String year) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.date = date;
        this.location = location;
        this.context = context;
        this.image = image;
        this.day = day;
        this.dayNum = dayNum;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayNum() {
        return dayNum;
    }

    public void setDayNum(String dayNum) {
        this.dayNum = dayNum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public event(String id) {
        this.id = id;
    }

    public event() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
