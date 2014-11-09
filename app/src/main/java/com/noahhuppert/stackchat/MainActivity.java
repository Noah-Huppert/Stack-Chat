package com.noahhuppert.stackchat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.noahhuppert.stackchat.controllers.NotificationController;
import com.noahhuppert.stackchat.controllers.PopNotificationController;
import com.noahhuppert.stackchat.models.ChatMessage;
import com.noahhuppert.stackchat.modules.BaseStackChatModule;
import com.noahhuppert.stackchat.modules.StackChatModule;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Main android activity
 */
public class MainActivity extends Activity {
    /**
     * Main ObjectGraph for Dagger
     */
    private ObjectGraph objectGraph;

    public NotificationController notificationController;

    /**
     * Android lifetime method
     * On startup, runs once
     * @param savedInstanceState Saved state from previous life cycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        objectGraph = ObjectGraph.create(new StackChatModule());

        notificationController = objectGraph.get(NotificationController.class);

        notificationController.showMessage(new ChatMessage(0, "HUD! Injected!", 0, 0), this);
    }


    /**
     * Inflates option menu
     * @param menu The menu to inflate
     * @return ?
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * On menu item click
     * @param item Item that is clicked
     * @return ?
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
