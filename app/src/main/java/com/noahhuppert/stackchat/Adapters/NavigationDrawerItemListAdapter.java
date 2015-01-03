package com.noahhuppert.stackchat.Adapters;

import com.noahhuppert.stackchat.Models.NavigationDrawerItem;
import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.ViewHolders.NavigationDrawerItemViewHolder;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class NavigationDrawerItemListAdapter extends ClickableRecyclerViewAdapter<NavigationDrawerItem, NavigationDrawerItemViewHolder> {

    public NavigationDrawerItemListAdapter(ArrayList<NavigationDrawerItem> data) {
        super(data, R.layout.navigation_drawer_item_card, NavigationDrawerItemViewHolder.class);
    }

    @Override
    public void runOnBindViewHolder(NavigationDrawerItemViewHolder holder, int position) {
        NavigationDrawerItem navigationDrawerItem = getData().get(position);

        holder.getIcon().setBackgroundResource(navigationDrawerItem.getIcon());
        holder.getText().setText(navigationDrawerItem.getText());
    }
}
