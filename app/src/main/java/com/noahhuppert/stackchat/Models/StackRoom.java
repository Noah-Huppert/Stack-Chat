package com.noahhuppert.stackchat.Models;

/**
 * Created by Noah Huppert on 1/1/2015.
 */
public class StackRoom {
    private int id;
    private String name;

    public StackRoom(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Getters */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /* Setters */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
