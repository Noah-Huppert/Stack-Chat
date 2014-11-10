package com.noahhuppert.stackchat.models;

/**
 * Created by Noah Huppert on 11/7/2014.
 */

/**
 * A StackOverflow chat user
 * Users are retrieved via the following Json format
 *      {
 *          "id": 0,
 *          "name": "Noah-Huppert",
 *          "email_hash": "!/Content/Img/feed-icon32.png",
 *          "reputation": 549,
 *          "is_moderator": false,
 *          "is_owner": null,
 *          "last_post": null,
 *          "last_seen": null
 *      }
 *
 * Via the following Url
 *      POST http://chat.stackoverflow.com/user/info
 *          Headers
 *              roomId
 *
 * The following parameters will be stored
 *      User Id
 *      Display name
 *      Avatar Url
 */
public class User {
    /**
     * StackOverflow user Id
     */
    private int userId;

    /**
     * StackOverflow display name
     */
    private String displayName;

    /**
     * StackOverflow avatar Url
     */
    private String avatarUrl;

    /**
     * Creates a new User
     * @param userId {@link com.noahhuppert.stackchat.models.User#userId}
     * @param displayName {@link com.noahhuppert.stackchat.models.User#displayName}
     * @param avatarUrl {@link com.noahhuppert.stackchat.models.User#avatarUrl}
     */
    public User(int userId, String displayName, String avatarUrl){
        this.userId = userId;
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
    }

    /* Getters */

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.User#userId}
     * @return {@link com.noahhuppert.stackchat.models.User#userId}
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.User#displayName}
     * @return {@link com.noahhuppert.stackchat.models.User#displayName}
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets the {@link com.noahhuppert.stackchat.models.User#avatarUrl}
     * @return {@link com.noahhuppert.stackchat.models.User#avatarUrl}
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /* Setters */

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.User#userId}
     * @param userId Value to set the {@link com.noahhuppert.stackchat.models.User#userId} to
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.User#displayName}
     * @param displayName Value to set the {@link com.noahhuppert.stackchat.models.User#displayName} to
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Sets the {@link com.noahhuppert.stackchat.models.User#avatarUrl}
     * @param avatarUrl Value to set the {@link com.noahhuppert.stackchat.models.User#avatarUrl} to
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
