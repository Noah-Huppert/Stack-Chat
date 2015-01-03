package com.noahhuppert.stackchat.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class NavigationDrawerItemViewHolder extends ClickableViewHolder {
    private ImageView icon;
    private TextView text;

    public NavigationDrawerItemViewHolder(View view){
        super(view);

        icon = (ImageView) view.findViewById(R.id.navigation_drawer_item_card_icon);
        text = (TextView) view.findViewById(R.id.navigation_drawer_item_card_text);
    }

    /* Actions */
    @Override
    public void setupClickListener(int index, ViewHolderClickListener viewHolderClickListener) {
        super.setupClickListener(index, viewHolderClickListener);
        setClickListenerOnView();
    }

    /* Getters */
    public ImageView getIcon() {
        return icon;
    }

    public TextView getText() {
        return text;
    }

    /* Setters */
    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public void setText(TextView text) {
        this.text = text;
    }
}
