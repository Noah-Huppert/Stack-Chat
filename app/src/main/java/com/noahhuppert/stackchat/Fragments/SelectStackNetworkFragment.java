package com.noahhuppert.stackchat.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.Adapters.StackNetworkListAdapter;
import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Interfaces.InterfaceHelper;
import com.noahhuppert.stackchat.Listeners.SelectStackNetworkFragment.StackNetworkCardListener;
import com.noahhuppert.stackchat.Models.StackNetwork;
import com.noahhuppert.stackchat.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectStackNetworkFragment extends BaseFragment {

    public SelectStackNetworkFragment(){
        fragmentLayout = R.layout.select_stack_network_fragment;
    }

    @Override
    public void runOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {
        super.runOnCreateView(inflater, container, savedInstanceState, rootView);

        RecyclerView networksList = (RecyclerView) rootView.findViewById(R.id.select_stack_network_fragment_list);

        StackNetworkListAdapter stackNetworkListAdapter = new StackNetworkListAdapter(fragmentToActivityBus.getStackNetworks());
        stackNetworkListAdapter.setOnClickListener(new StackNetworkCardListener(fragmentToActivityBus.getStackNetworks(), fragmentToActivityBus));

        networksList.setHasFixedSize(true);
        networksList.setLayoutManager(new LinearLayoutManager(getActivity()));

        networksList.setAdapter(stackNetworkListAdapter);
    }
}
