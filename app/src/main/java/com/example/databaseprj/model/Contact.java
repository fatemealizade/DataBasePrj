package com.example.databaseprj.model;

public class Contact {

    private int id;
    private String name;
    private String phoneNum;

    public Contact() {
    }

    public Contact(int id, String name, String phoneNum) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
