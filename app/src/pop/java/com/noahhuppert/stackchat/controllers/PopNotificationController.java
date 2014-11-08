package com.noahhuppert.stackchat.controllers;

/**
 * Created by Noah Huppert on 11/8/2014.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.models.ChatMessage;

/**
 * Created by Noah Huppert on 11/8/2014.
 */
public class PopNotificationController extends NotificationController {
    public void showMessage(ChatMessage message, Context context){
        Log.w("Notifications", "Showing message: " + message.getContent());

        Notification.Builder builder = new Notification.Builder(context);

        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setCategory(Notification.CATEGORY_MESSAGE);
        builder.setContentTitle(message.getContent());
        builder.setContentText(message.getContent());

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());
    }
}
