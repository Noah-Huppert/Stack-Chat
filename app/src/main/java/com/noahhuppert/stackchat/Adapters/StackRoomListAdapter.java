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
public class StackRoomListAdapter extends RecyclerView.Adapter<StackRoomViewHolder> implements ViewHolderClickListener{
    private ArrayList<StackRoom> stackRooms;
    private ViewHolderClickListener viewHolderClickListener;

    public StackRoomListAdapter(ArrayList<StackRoom> stackRooms){
        this.stackRooms = stackRooms;
    }

    public void addOnClickListener(ViewHolderClickListener viewHolderClickListener){
        this.viewHolderClickListener = viewHolderClickListener;
    }

    @Override
    public void onClick(int index){
        if(viewHolderClickListener != null){
            viewHolderClickListener.onClick(index);
        }
    }

    @Override
    public StackRoomViewHolder onCreateViewHolder(ViewGroup viewGroup, int index){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stack_room_list_card, viewGroup, false);

        return new StackRoomViewHolder(itemView);
    }

    @Override
    public int getItemCount(){
        return this.stackRooms.size();
    }

    @Override
    public void onBindViewHolder(StackRoomViewHolder stackRoomViewHolder, int index){
        StackRoom stackRoom = getStackRooms().get(index);

        stackRoomViewHolder.getName().setText(stackRoom.getName());
        stackRoomViewHolder.getDescription().setText(stackRoom.getDescription());

        stackRoomViewHolder.setupClickListener(index, this);
    }

    /* Getters */
    public ArrayList<StackRoom> getStackRooms() {
        return stackRooms;
    }

    /* Setters */
    public void setStackRooms(ArrayList<StackRoom> stackRooms) {
        this.stackRooms = stackRooms;
    }
}
