package com.noahhuppert.stackchat.Interfaces;

import android.app.Fragment;
import android.os.Bundle;

import com.noahhuppert.stackchat.Models.StackNetwork;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public interface FragmentToActivityBus {
    public void switchFragment(String fragmentId, Bundle bundle);
    public void switchFragment(String fragmentId);

    public ArrayList<StackNetwork> getStackNetworks();
}
