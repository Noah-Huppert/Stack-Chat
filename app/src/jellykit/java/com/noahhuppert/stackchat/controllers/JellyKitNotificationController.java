package com.noahhuppert.stackchat.controllers;

/**
 * Created by Noah Huppert on 11/8/2014.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.models.Message;

/**
 * Created by Noah Huppert on 11/8/2014.
 */
public class JellyKitNotificationController extends NotificationController {
    public int showMessage(Message message, Context context){
        int notificationId = 0;

        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentTitle("New message");
        builder.setContentText(message.getContent());
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setVibrate(new long[]{Notification.DEFAULT_VIBRATE});
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());

        return notificationId;
    }
}
