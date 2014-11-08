package com.noahhuppert.stackchat.controllers;

import android.content.Context;
import android.util.Log;

import com.noahhuppert.stackchat.models.ChatMessage;

import javax.inject.Inject;

/**
 * Created by Noah Huppert on 11/8/2014.
 */
public class PopNotificationController extends NotificationController {
    public void showMessage(ChatMessage message, Context context){
        Log.w("Notifications", "Showing message: " + message.getContent());
    }
}
