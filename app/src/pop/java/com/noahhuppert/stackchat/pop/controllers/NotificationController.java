package com.noahhuppert.stackchat.pop.controllers;

import javax.inject.Singleton;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Noah Huppert on 11/6/2014.
 */

@Singleton
public class NotificationController extends com.noahhuppert.stackchat.controllers.NotificationController {

    public NotificationController(Context context){
        super(context);
    }

    @Override
    public void show(String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
    }
}
