package com.noahhuppert.stackchat.controllers;

import android.content.Context;

import com.noahhuppert.stackchat.models.ChatMessage;

/**
 * Created by Noah Huppert on 11/8/2014.
 */
public abstract class NotificationController {
    public abstract int showMessage(ChatMessage chatMessage, Context context);
}
