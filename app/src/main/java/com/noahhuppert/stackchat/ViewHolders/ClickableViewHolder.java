package com.noahhuppert.stackchat.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class ClickableViewHolder extends RecyclerView.ViewHolder {
    private int index;
    private ViewHolderClickListener viewHolderClickListener;

    public ClickableViewHolder(View view){
        super(view);
    }

    /* Actions */
    public void setupClickListener(int index, ViewHolderClickListener viewHolderClickListener){
        this.index = index;
        this.viewHolderClickListener = viewHolderClickListener;
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
