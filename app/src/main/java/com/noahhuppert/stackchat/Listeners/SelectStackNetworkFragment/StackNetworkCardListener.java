package com.noahhuppert.stackchat.Listeners.SelectStackNetworkFragment;

import android.os.Bundle;

import com.noahhuppert.stackchat.Fragments.StackNetworkRoomsFragment;
import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.Activities.MainActivity;
import com.noahhuppert.stackchat.Models.StackNetwork;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkCardListener implements ViewHolderClickListener {
    private ArrayList<StackNetwork> stackNetworks;
    private FragmentToActivityBus fragmentToActivityBus;

    public StackNetworkCardListener(ArrayList<StackNetwork> stackNetworks, FragmentToActivityBus fragmentToActivityBus){
        this.stackNetworks = stackNetworks;
        this.fragmentToActivityBus = fragmentToActivityBus;
    }

    @Override
    public void onClick(int index){
        if(index <= stackNetworks.size()) {
            Bundle data = new Bundle();
            data.putInt(StackNetworkRoomsFragment.BUNDLE_SELECTED_NETWORK_KEY, index);

            fragmentToActivityBus.switchFragment(MainActivity.FRAGMENT_STACK_NETWORK_ROOMS, data);
        }
    }
}
