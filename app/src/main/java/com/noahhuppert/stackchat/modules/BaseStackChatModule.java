package com.noahhuppert.stackchat.modules;

/**
 * Created by Noah Huppert on 11/7/2014.
 */

import android.util.Log;

import com.noahhuppert.stackchat.MainActivity;
import com.noahhuppert.stackchat.controllers.NotificationController;
import com.noahhuppert.stackchat.controllers.PopNotificationController;

import dagger.Module;
import dagger.Provides;

/**
 * Base StackChat module for Dagger
 * Provides all non flavor specific injections
 */
@Module(
        complete = false
)
public class BaseStackChatModule {

}
