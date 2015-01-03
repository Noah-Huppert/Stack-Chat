package com.noahhuppert.stackchat.Listeners.NavigationDrawer;

import android.util.Log;
import android.view.Gravity;

import com.noahhuppert.stackchat.Activities.MainActivity;
import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class NavigationDrawerItemListener implements ViewHolderClickListener {
    private FragmentToActivityBus fragmentToActivityBus;

    public NavigationDrawerItemListener(FragmentToActivityBus fragmentToActivityBus){
        this.fragmentToActivityBus = fragmentToActivityBus;
    }

    @Override
    public void onClick(int index) {
        switch(index){
            case 0://Select Room
                fragmentToActivityBus.switchFragment(MainActivity.FRAGMENT_SELECT_STACK_NETWORK);
                break;

            case 1://Favorite Rooms
                //TODO Implement Favorite Rooms
                Log.d("NavigationDrawerItemListener", "\"Favorite Rooms\" Drawer Item Clicked");
                break;

            case 2://Logout
                fragmentToActivityBus.switchFragment(MainActivity.FRAGMENT_LOGIN);
                break;

            case 3://Settings
                //TODO Implement Settings
                Log.d("NavigationDrawerItemListener", "\"Settings\" Drawer Item Clicked");
                break;
        }
    }
}
