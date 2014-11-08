package com.noahhuppert.stackchat.controllers;

/**
 * Created by Noah Huppert on 11/6/2014.
 */

import android.content.Context;

import com.noahhuppert.stackchat.models.ChatMessage;

import javax.inject.Singleton;

/**
 * Class that will display and manage notifications
 */
@Singleton
public abstract class NotificationController {
    public abstract void showMessage(ChatMessage chatMessage, Context context);
}
