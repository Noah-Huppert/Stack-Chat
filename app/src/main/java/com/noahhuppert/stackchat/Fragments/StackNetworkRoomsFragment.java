package com.noahhuppert.stackchat.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noahhuppert.stackchat.Models.GetStackNetworkRoomsBundle;
import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.Tasks.GetStackNetworkRoomsTask;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkRoomsFragment extends BaseFragment {
    public static final String BUNDLE_SELECTED_NETWORK_KEY = "BUNDLE_SELECTED_NETWORK_KEY";
    private int selectedNetworkKey;
    private int roomsIndexPage;

    public StackNetworkRoomsFragment(){
        fragmentLayout = R.layout.stack_network_rooms_fragment;
        roomsIndexPage = 1;
    }

    @Override
    public void runOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {
        super.runOnCreateView(inflater, container, savedInstanceState, rootView);

        TextView stackNetworkName = (TextView) rootView.findViewById(R.id.stack_network_rooms_network_name);

        selectedNetworkKey = getArguments().getInt(BUNDLE_SELECTED_NETWORK_KEY);

        stackNetworkName.setText(fragmentToActivityBus.getStackNetworks().get(selectedNetworkKey).getName());

        GetStackNetworkRoomsTask getStackNetworkRooms = new GetStackNetworkRoomsTask();
        getStackNetworkRooms.execute(new GetStackNetworkRoomsBundle(fragmentToActivityBus.getStackNetworks().get(selectedNetworkKey), roomsIndexPage));
        //TODO Create real layout with RecyclerView of rooms
    }
}
