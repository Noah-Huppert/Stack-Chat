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
public class StackNetworkListAdapter extends ClickableRecyclerViewAdapter<StackNetwork, StackNetworkViewHolder>{

    public StackNetworkListAdapter(ArrayList<StackNetwork> data) {
        super(data, R.layout.stack_network_card, StackNetworkViewHolder.class);
    }

    @Override
    public void runOnBindViewHolder(StackNetworkViewHolder stackNetworkViewHolder, int index){
        StackNetwork stackNetwork = getData().get(index);

        stackNetworkViewHolder.getName().setText(stackNetwork.getName());
        stackNetworkViewHolder.getIcon().setBackgroundResource(stackNetwork.getIcon());
    }
}
