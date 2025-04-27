package com.shoppingApp.demo.domain;

public class User {
    private String name;
    private long phoneNumber;
    private String email;
    private String passowrd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", passowrd='" + passowrd + '\'' +
                '}';
    }

    public User(String name, long phoneNumber, String email, String passowrd) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passowrd = passowrd;
    }
    public User (){

    }


}
