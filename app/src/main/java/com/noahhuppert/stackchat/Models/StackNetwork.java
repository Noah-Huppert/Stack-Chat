package com.noahhuppert.stackchat.Models;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetwork {
    private String name;
    private String url;
    private int icon;

    public StackNetwork(String name, String url, int icon){
        this.name = name;
        this.url = url;
        this.icon = icon;
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getIcon() {
        return icon;
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
