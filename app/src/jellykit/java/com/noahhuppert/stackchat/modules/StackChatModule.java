package com.noahhuppert.stackchat.modules;

/**
 * Created by Noah Huppert on 11/7/2014.
 */

import com.noahhuppert.stackchat.controllers.JellyKitNotificationController;
import com.noahhuppert.stackchat.controllers.NotificationController;

import dagger.Module;
import dagger.Provides;

/**
 * Module for all pop flavor specific injections
 */
@Module(
        overrides = true,
        includes = BaseStackChatModule.class,
        injects = {
                NotificationController.class
        }

)
public class StackChatModule {
    /**
     * Provides a {@link com.noahhuppert.stackchat.controllers.JellyKitNotificationController} for Dagger
     * @return
     */
    @Provides
    public NotificationController provideNotificationController(){
        return new JellyKitNotificationController();
    }
}
