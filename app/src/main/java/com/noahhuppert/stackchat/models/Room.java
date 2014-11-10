package com.noahhuppert.stackchat.models;

/**
 * Created by Noah Huppert on 11/9/2014.
 */

import java.util.ArrayList;

/**
 * A StackOverflow chat room
 */
public class Room {
    /**
     * StackOverflow room Id
     */
    private int id;

    /**
     * A list of all users in the room
     */
    private ArrayList<User> users;

    /**
     * A list of all messages in the room
     */
    private ArrayList<Message> messages;

    /**
     * Creates a new room
     * @param id {@link com.noahhuppert.stackchat.models.Room#id}
     */
    public Room(int id){
        this.id = id;
        users = new ArrayList<User>();
        messages = new ArrayList<Message>();
    }

    /* Getters */
    /**
     * Gets the {@link com.noahhuppert.stackchat.models.Room#id}
     * @return {@link com.noahhuppert.stackchat.models.Room#id}
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.Room#users}
     * @return {@link com.noahhuppert.stackchat.models.Room#users}
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.Room#messages}
     * @return {@link com.noahhuppert.stackchat.models.Room#messages}
     */
    public ArrayList<Message> getMessages() {
        return messages;
    }

    /**
     * Get message by {@link com.noahhuppert.stackchat.models.Message#id}
     * @param messageId {@link com.noahhuppert.stackchat.models.Message#id}
     * @return The message, or null of none are found
     */
    public Message getMessageById(int messageId){
        for(Message message : getMessages()){
            if(message.getId() == messageId){
                return message;
            }
        }

        return null;
    }

    /* Setters */
    /**
     * Sets the {@link com.noahhuppert.stackchat.models.Room#id}
     * @param id Value to set the {@link com.noahhuppert.stackchat.models.Room#id} to
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.Room#users}
     * @param users Value to set the {@link com.noahhuppert.stackchat.models.Room#users} to
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.Room#messages}
     * @param messages Value to set the {@link com.noahhuppert.stackchat.models.Room#messages} to
     */
    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){

    }
}
