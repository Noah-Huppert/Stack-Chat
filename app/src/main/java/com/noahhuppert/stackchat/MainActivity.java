package com.noahhuppert.stackchat;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.noahhuppert.stackchat.controllers.NotificationController;
import com.noahhuppert.stackchat.fragments.RoomFragment;
import com.noahhuppert.stackchat.models.Room;
import com.noahhuppert.stackchat.modules.BaseStackChatModule;
import com.noahhuppert.stackchat.modules.StackChatModule;
import com.noahhuppert.stackchat.tasks.UpdateRoomMessagesTask;

import dagger.ObjectGraph;

/**
 * Main android activity
 */
public class MainActivity extends Activity {
    //Constants
    /**
     * Log Tag
     */
    public static final String LOG_TAG = "Stack Chat Log";

    //Android
    public FragmentManager fragmentManager;

    //Dagger
    /**
     * Main ObjectGraph for Dagger
     */
    public static ObjectGraph objectGraph = ObjectGraph.create(new BaseStackChatModule(), new StackChatModule());
    /**
     * Android notification manager
     */
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

        //Android vars
        fragmentManager = getFragmentManager();

        //Dagger
        notificationController = objectGraph.get(NotificationController.class);

        //Set fragment
        RoomFragment roomFragment = new RoomFragment();

        fragmentManager.beginTransaction()
                .add(R.id.mainFragment, roomFragment)
                .commit();
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
