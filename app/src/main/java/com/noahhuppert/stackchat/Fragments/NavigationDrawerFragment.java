package com.noahhuppert.stackchat.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.Adapters.NavigationDrawerItemListAdapter;
import com.noahhuppert.stackchat.Listeners.NavigationDrawer.NavigationDrawerItemListener;
import com.noahhuppert.stackchat.Models.NavigationDrawerItem;
import com.noahhuppert.stackchat.R;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/27/2014.
 */
public class NavigationDrawerFragment extends BaseFragment {
    public NavigationDrawerFragment(){
        fragmentLayout = R.layout.navigation_drawer_fragment;
    }

    @Override
    public void runOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {
        super.runOnCreateView(inflater, container, savedInstanceState, rootView);

        RecyclerView drawerItemsList = (RecyclerView) rootView.findViewById(R.id.navigation_drawer_fragment_items);

        ArrayList<NavigationDrawerItem> navigationDrawerItems = new ArrayList<NavigationDrawerItem>();
        navigationDrawerItems.add(new NavigationDrawerItem(R.drawable.ic_list, "Select Room"));
        navigationDrawerItems.add(new NavigationDrawerItem(R.drawable.ic_favorite, "Favorite Rooms"));
        navigationDrawerItems.add(new NavigationDrawerItem(R.drawable.ic_settings, "Settings"));

        NavigationDrawerItemListAdapter navigationDrawerItemListAdapter = new NavigationDrawerItemListAdapter(navigationDrawerItems);
        navigationDrawerItemListAdapter.setOnClickListener(new NavigationDrawerItemListener(fragmentToActivityBus));

        drawerItemsList.setHasFixedSize(true);
        drawerItemsList.setLayoutManager(new LinearLayoutManager(getActivity()));

        drawerItemsList.setAdapter(navigationDrawerItemListAdapter);

        //TODO Make Settings be at bottom
    }
}
