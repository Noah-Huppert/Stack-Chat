package com.noahhuppert.stackchat.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.Listeners.StackNetworkViewholderListener;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class ClickableViewHolder extends RecyclerView.ViewHolder {
    protected View view;

    private int index;
    private ViewHolderClickListener viewHolderClickListener;

    public ClickableViewHolder(View view){
        super(view);
        this.view = view;
    }

    /* Actions */
    public void setupClickListener(int index, ViewHolderClickListener viewHolderClickListener){
        this.index = index;
        this.viewHolderClickListener = viewHolderClickListener;
    }

    protected void setClickListenerOnView(){
        view.setOnClickListener(new StackNetworkViewholderListener(getIndex(), getViewHolderClickListener()));
    }

    /* Getters */
    public int getIndex() {
        return index;
    }

    public ViewHolderClickListener getViewHolderClickListener() {
        return viewHolderClickListener;
    }

    /* Setters */
    public void setIndex(int index) {
        this.index = index;
    }

    public void setViewHolderClickListener(ViewHolderClickListener viewHolderClickListener) {
        this.viewHolderClickListener = viewHolderClickListener;
    }
}
