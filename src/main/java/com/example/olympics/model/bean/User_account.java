package com.example.olympics.model.bean;

public class User_account {
    String user_id,full_name,email,password,user_type;

    public User_account(String user_id, String full_name, String email, String password, String user_type) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.user_type = user_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}
