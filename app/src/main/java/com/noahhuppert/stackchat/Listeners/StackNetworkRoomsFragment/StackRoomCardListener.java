package com.noahhuppert.stackchat.Listeners.StackNetworkRoomsFragment;

import android.util.Log;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class StackRoomCardListener implements ViewHolderClickListener {
    @Override
    public void onClick(int index) {
        Log.d("StackRoomCardListener", "Clicked " + index);
    }
}
