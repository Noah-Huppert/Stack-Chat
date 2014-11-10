package com.noahhuppert.stackchat.controllers;

import android.content.Context;

import com.noahhuppert.stackchat.models.Message;

/**
 * Created by Noah Huppert on 11/8/2014.
 */
public abstract class NotificationController {
    public static final int UNREAD_MESSAGES_NOTIFICATION_ID = 0;
    public static final int MENTIONED_NOTIFICATION_ID = 1;

    public abstract int showMessage(Message chatMessage, Context context);
}
