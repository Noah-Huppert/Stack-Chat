package com.noahhuppert.stackchat.controllers;

/**
 * Created by Noah Huppert on 11/6/2014.
 */

import android.content.Context;

import javax.inject.Singleton;

/**
 * Class that will display and manage notifications
 */
@Singleton
public class NotificationController {
    private Context context;

    public NotificationController(Context context){
        this.context = context;
    }
    public void show(String message){

    };
}
