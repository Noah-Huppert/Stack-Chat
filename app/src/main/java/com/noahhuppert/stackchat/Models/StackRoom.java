package com.noahhuppert.stackchat.Models;

/**
 * Created by Noah Huppert on 1/1/2015.
 */
public class StackRoom {
    private int id;
    private String name;
    private String description;

    public StackRoom(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /* Getters */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    /* Setters */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
