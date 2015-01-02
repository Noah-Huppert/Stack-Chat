package com.noahhuppert.stackchat.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class StackRoomViewHolder extends ClickableViewHolder {
    private TextView name;
    private TextView description;

    public StackRoomViewHolder(View view){
        super(view);

        this.name = (TextView) view.findViewById(R.id.stack_room_list_card_name);
        this.description = (TextView) view.findViewById(R.id.stack_room_list_card_description);
    }

    /* Actions */
    @Override
    public void setupClickListener(int index, ViewHolderClickListener viewHolderClickListener) {
        super.setupClickListener(index, viewHolderClickListener);
        setClickListenerOnView();
    }

    /* Getters */
    public TextView getName() {
        return name;
    }

    public TextView getDescription() {
        return description;
    }

    /* Setters */
    public void setName(TextView name) {
        this.name = name;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }
}
