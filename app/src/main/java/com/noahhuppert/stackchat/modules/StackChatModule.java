package com.noahhuppert.stackchat.modules;

/**
 * Created by Noah Huppert on 11/6/2014.
 */

import com.noahhuppert.stackchat.controllers.NotificationController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Main Dagger Module
 */
@Module
public class StackChatModule {
    /**
     * Provides the NotificationController
     * Provides a singleton
     * @return A NotificationController
     */
    @Provides
    @Singleton
    public NotificationController provideNotificationController(){
        return new NotificationController();
    }
}
