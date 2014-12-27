package com.noahhuppert.stackchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.Models.StackNetwork;
import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.ViewHolders.StackNetworkViewHolder;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkListAdapter extends RecyclerView.Adapter<StackNetworkViewHolder> implements ViewHolderClickListener{
    private ArrayList<StackNetwork> stackNetworks;
    private ViewHolderClickListener viewHolderClickListener;

    public StackNetworkListAdapter(ArrayList<StackNetwork> stackNetworks){
        this.stackNetworks = stackNetworks;
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
    public StackNetworkViewHolder onCreateViewHolder(ViewGroup viewGroup, int index){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stack_network_card, viewGroup, false);

        return new StackNetworkViewHolder(itemView);
    }

    @Override
    public int getItemCount(){
        return this.stackNetworks.size();
    }

    @Override
    public void onBindViewHolder(StackNetworkViewHolder stackNetworkViewHolder, int index){
        StackNetwork stackNetwork = getStackNetworks().get(index);

        stackNetworkViewHolder.getName().setText(stackNetwork.getName());
        stackNetworkViewHolder.getIcon().setBackgroundResource(stackNetwork.getIcon());

        stackNetworkViewHolder.setupClickListener(index, this);
    }

    /* Getters */
    public ArrayList<StackNetwork> getStackNetworks() {
        return stackNetworks;
    }

    /* Setters */
    public void setStackNetworks(ArrayList<StackNetwork> stackNetworks) {
        this.stackNetworks = stackNetworks;
    }
}
