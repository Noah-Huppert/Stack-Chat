package com.noahhuppert.stackchat.models;

/**
 * Created by Noah Huppert on 11/7/2014.
 */

/**
 * A model for storing a chat message
 * Chat messages are received in the following Json format
 *
 *      {
 *          "event_type":1,
 *          "time_stamp":1415394827,
 *          "content":"*Test message, for things",
 *          "id":40213018,
 *          "user_id":1478191,
 *          "user_name":"Noah Huppert",
 *          "room_id":15,
 *          "room_name":"Android",
 *          "message_id":19847812
 *      }
 *
 * Model will save the following parameters
 *      id
 *      content
 *      timeStamp
 *      userId
 */
public class ChatMessage {
    /**
     * Message Id
     */
    private int id;

    /**
     * Message content
     */
    private String content;

    /**
     * Time message was sent
     */
    private int timeStamp;

    /**
     * User Id of message
     */
    private int userId;

    /**
     * Creates a new ChatMessage
     * @param id {@link com.noahhuppert.stackchat.models.ChatMessage#id}
     * @param content {@link com.noahhuppert.stackchat.models.ChatMessage#content}
     * @param timeStamp {@link com.noahhuppert.stackchat.models.ChatMessage#timeStamp}
     * @param userId {@link com.noahhuppert.stackchat.models.ChatMessage#userId}
     */
    public ChatMessage(int id, String content, int timeStamp, int userId){
        this.id = id;
        this.content = content;
        this.timeStamp = timeStamp;
        this.userId = userId;
    }

    /* Getters */
    /**
     * Gets the {@link com.noahhuppert.stackchat.models.ChatMessage#id}
     * @return {@link com.noahhuppert.stackchat.models.ChatMessage#id}
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.ChatMessage#content}
     * @return {@link com.noahhuppert.stackchat.models.ChatMessage#content}
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.ChatMessage#timeStamp}
     * @return {@link com.noahhuppert.stackchat.models.ChatMessage#timeStamp}
     */
    public int getTimeStamp() {
        return timeStamp;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.ChatMessage#userId}
     * @return {@link com.noahhuppert.stackchat.models.ChatMessage#userId}
     */
    public int getUserId() {
        return userId;
    }

    /* Setters */
    /**
     * Sets the {@link com.noahhuppert.stackchat.models.ChatMessage#id}
     * @param id {@link com.noahhuppert.stackchat.models.ChatMessage#id}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.ChatMessage#content}
     * @param content {@link com.noahhuppert.stackchat.models.ChatMessage#content}
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.ChatMessage#timeStamp}
     * @param timeStamp {@link com.noahhuppert.stackchat.models.ChatMessage#timeStamp}
     */
    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.ChatMessage#userId}
     * @param userId {@link com.noahhuppert.stackchat.models.ChatMessage#userId}
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
