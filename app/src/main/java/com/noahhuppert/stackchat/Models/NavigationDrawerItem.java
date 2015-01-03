package com.noahhuppert.stackchat.Models;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class NavigationDrawerItem {
    private int icon;
    private String text;

    public NavigationDrawerItem(int icon, String text){
        this.icon = icon;
        this.text = text;
    }

    /* Getters */
    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    /* Setters */
    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setText(String text) {
        this.text = text;
    }
}
