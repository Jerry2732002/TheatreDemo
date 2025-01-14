package com.example.Theatre.entity;

public class Theatre {
    private int id;
    private String name;
    private String location;


    public Theatre() {
    }

    public Theatre(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
