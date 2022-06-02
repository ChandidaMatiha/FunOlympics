package com.example.olympics.model.bean;

public class Broadcast {
    String id,broadcastName,sportName,url;
    String eventTitle,date,location,context,image;


    public Broadcast(String id, String broadcastName, String sportName, String url) {
        this.id = id;
        this.broadcastName = broadcastName;
        this.sportName = sportName;
        this.url = url;
    }

    public Broadcast(String id, String broadcastName, String sportName, String url, String eventTitle, String date, String location, String context, String image) {
        this.id = id;
        this.broadcastName = broadcastName;
        this.sportName = sportName;
        this.url = url;
        this.eventTitle = eventTitle;
        this.date = date;
        this.location = location;
        this.context = context;
        this.image = image;
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

    public Broadcast() {

    }

    public Broadcast(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBroadcastName() {
        return broadcastName;
    }

    public void setBroadcastName(String broadcastName) {
        this.broadcastName = broadcastName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
