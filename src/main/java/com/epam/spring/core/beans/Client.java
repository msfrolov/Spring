package com.epam.spring.core.beans;

public class Client {
    private String id;
    private String fullName;

    public Client() {
        this.id = "1";
        this.fullName = "John Smith";
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}