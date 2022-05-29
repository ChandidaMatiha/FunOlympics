package com.example.olympics.model.bean;

public class Broadcast {
    String id,broadcastName,sportName,url;


    public Broadcast(String id, String broadcastName, String sportName, String url) {
        this.id = id;
        this.broadcastName = broadcastName;
        this.sportName = sportName;
        this.url = url;
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
