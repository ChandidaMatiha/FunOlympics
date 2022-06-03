package com.example.olympics.model.bean;

public class medals {
    String country,gold, Silver, bronze,total;

    public medals(String country, String gold, String silver, String bronze, String total) {
        this.country = country;
        this.gold = gold;
        Silver = silver;
        this.bronze = bronze;
        this.total = total;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getSilver() {
        return Silver;
    }

    public void setSilver(String silver) {
        Silver = silver;
    }

    public String getBronze() {
        return bronze;
    }

    public void setBronze(String bronze) {
        this.bronze = bronze;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
