package com.noahhuppert.stackchat.modules;

/**
 * Created by Noah Huppert on 11/7/2014.
 */

import com.noahhuppert.stackchat.controllers.NotificationController;
import com.noahhuppert.stackchat.controllers.PopNotificationController;

import dagger.Module;
import dagger.Provides;

/**
 * Module for all pop flavor specific injections
 */
@Module(
        overrides = true,
        addsTo = BaseStackChatModule.class
)
public class StackChatModule {
    /**
     * Provides a {@link com.noahhuppert.stackchat.controllers.PopNotificationController} for Dagger
     * @return
     */
    @Provides
    public NotificationController provideNotificationController(){
        return new PopNotificationController();
    }
}
