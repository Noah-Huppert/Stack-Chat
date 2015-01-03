package com.noahhuppert.stackchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.Models.StackRoom;
import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.ViewHolders.StackRoomViewHolder;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class StackRoomListAdapter extends ClickableRecyclerViewAdapter<StackRoom, StackRoomViewHolder>{

    public StackRoomListAdapter(ArrayList<StackRoom> data){
        super(data, R.layout.stack_room_list_card, StackRoomViewHolder.class);
    }

    @Override
    public void runOnBindViewHolder(StackRoomViewHolder stackRoomViewHolder, int index){
        StackRoom stackRoom = getData().get(index);

        stackRoomViewHolder.getName().setText(stackRoom.getName());
        stackRoomViewHolder.getDescription().setText(stackRoom.getDescription());
    }
}
