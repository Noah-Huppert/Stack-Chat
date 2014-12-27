package com.noahhuppert.stackchat.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.Listeners.StackNetworkViewholderListener;
import com.noahhuppert.stackchat.Models.StackNetwork;
import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkViewHolder extends ClickableViewHolder {
    private View view;
    private TextView name;
    private ImageView icon;

    public StackNetworkViewHolder(View view){
        super(view);
        this.view = view;
        name = (TextView) view.findViewById(R.id.stack_network_card_name);
        icon = (ImageView) view.findViewById(R.id.stack_network_card_icon);
    }

    /* Actions */

    @Override
    public void setupClickListener(int index, ViewHolderClickListener viewHolderClickListener) {
        super.setupClickListener(index, viewHolderClickListener);
        view.setOnClickListener(new StackNetworkViewholderListener(getIndex(), getViewHolderClickListener()));
    }

    /* Getters */
    public TextView getName() {
        return name;
    }

    public ImageView getIcon() {
        return icon;
    }

    /* Setters */
    public void setName(TextView name) {
        this.name = name;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }
}
