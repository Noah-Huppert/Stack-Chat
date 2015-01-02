package com.noahhuppert.stackchat.Interfaces;

import com.noahhuppert.stackchat.Models.StackRoom;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public interface GetStackNetworkRoomsInterface {
    public void onRetrievedRooms(ArrayList<StackRoom> rooms);
}
