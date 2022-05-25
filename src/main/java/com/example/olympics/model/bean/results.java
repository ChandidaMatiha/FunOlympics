package com.example.olympics.model.bean;

public class results {
    String id,sportTitle,winnersName,country,medal;

    public results(String id, String sportTitle, String winnersName, String country, String medal) {
        this.id = id;
        this.sportTitle = sportTitle;
        this.winnersName = winnersName;
        this.country = country;
        this.medal = medal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSportTitle() {
        return sportTitle;
    }

    public void setSportTitle(String sportTitle) {
        this.sportTitle = sportTitle;
    }

    public String getWinnersName() {
        return winnersName;
    }

    public void setWinnersName(String winnersName) {
        this.winnersName = winnersName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }
}
