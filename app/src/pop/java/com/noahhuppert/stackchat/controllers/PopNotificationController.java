package com.noahhuppert.stackchat.controllers;

import android.app.Notification;
import android.content.Context;

import com.noahhuppert.stackchat.models.ChatMessage;

/**
 * Created by Noah Huppert on 11/7/2014.
 */
public class PopNotificationController extends NotificationController {
    public void showMessage(ChatMessage chatMessage, Context context){
        Notification.Builder builder = new Notification.Builder(context);

        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setCategory(Notification.CATEGORY_MESSAGE);
        builder.setContentText(chatMessage.getContent());
    }
}
