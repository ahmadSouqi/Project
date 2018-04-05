package com.domin.model;

import java.io.Serializable;

/**
 * Created by asouqi on 3/15/18.
 */
public class User implements Serializable {

    private String userName;
    private String password;
    private String roll;

    public User(String userName, String password, String roll) {
        this.userName = userName;
        this.password = password;
        this.roll = roll;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roll='" + roll + '\'' +
                '}';
    }
}
