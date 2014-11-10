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
 * Via this Url
 *      POST http://chat.stackoverflow.com/chats/15/events
 *          Headers
 *              since: 0
 *              mode: Messages
 *              msgCount: 1000
 *
 * Model will save the following parameters
 *      id
 *      content
 *      timeStamp
 *      userId
 */
public class Message {
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
     * @param id {@link Message#id}
     * @param content {@link Message#content}
     * @param timeStamp {@link Message#timeStamp}
     * @param userId {@link Message#userId}
     */
    public Message(int id, String content, int timeStamp, int userId){
        this.id = id;
        this.content = content;
        this.timeStamp = timeStamp;
        this.userId = userId;
    }

    /* Getters */
    /**
     * Gets the {@link Message#id}
     * @return {@link Message#id}
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the {@link Message#content}
     * @return {@link Message#content}
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the {@link Message#timeStamp}
     * @return {@link Message#timeStamp}
     */
    public int getTimeStamp() {
        return timeStamp;
    }

    /**
     * Gets the {@link Message#userId}
     * @return {@link Message#userId}
     */
    public int getUserId() {
        return userId;
    }

    /* Setters */
    /**
     * Sets the {@link Message#id}
     * @param id {@link Message#id}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the {@link Message#content}
     * @param content {@link Message#content}
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Sets the {@link Message#timeStamp}
     * @param timeStamp {@link Message#timeStamp}
     */
    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Sets the {@link Message#userId}
     * @param userId {@link Message#userId}
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
