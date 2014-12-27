package com.noahhuppert.stackchat.Listeners;

import android.view.View;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkViewholderListener implements View.OnClickListener {
    private int index;
    private ViewHolderClickListener viewHolderClickListener;

    public StackNetworkViewholderListener(int index, ViewHolderClickListener viewHolderClickListener){
        this.index = index;
        this.viewHolderClickListener = viewHolderClickListener;
    }

    @Override
    public void onClick(View view){
        viewHolderClickListener.onClick(index);
    }
}
