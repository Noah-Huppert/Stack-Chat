package com.noahhuppert.stackchat.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noahhuppert.stackchat.Adapters.StackRoomListAdapter;
import com.noahhuppert.stackchat.Interfaces.GetStackNetworkRoomsInterface;
import com.noahhuppert.stackchat.Listeners.SelectStackNetworkFragment.StackNetworkCardListener;
import com.noahhuppert.stackchat.Listeners.StackNetworkRoomsFragment.StackRoomCardListener;
import com.noahhuppert.stackchat.Models.StackRoom;
import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.Tasks.GetStackNetworkRoomsTask;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkRoomsFragment extends BaseFragment implements GetStackNetworkRoomsInterface{
    public static final String BUNDLE_SELECTED_NETWORK_KEY = "BUNDLE_SELECTED_NETWORK_KEY";

    private GetStackNetworkRoomsTask getStackNetworkRoomsTask;
    private StackRoomListAdapter stackRoomListAdapter;
    private RecyclerView roomsList;

    private int selectedNetworkKey;
    private int roomsIndexPage;

    public StackNetworkRoomsFragment(){
        fragmentLayout = R.layout.stack_network_rooms_fragment;
        roomsIndexPage = 1;
    }

    @Override
    public void runOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {
        super.runOnCreateView(inflater, container, savedInstanceState, rootView);

        selectedNetworkKey = getArguments().getInt(BUNDLE_SELECTED_NETWORK_KEY);

        TextView helperText = (TextView) rootView.findViewById(R.id.stack_network_rooms_helper_text);
        helperText.setText("Select a " + fragmentToActivityBus.getStackNetworks().get(selectedNetworkKey).getName() + " Chat Room");

        getStackNetworkRoomsTask = new GetStackNetworkRoomsTask(this, fragmentToActivityBus.getStackNetworks().get(selectedNetworkKey));
        getStackNetworkRoomsTask.execute(roomsIndexPage);

        roomsList = (RecyclerView) rootView.findViewById(R.id.stack_network_rooms_fragment_list);

        stackRoomListAdapter = new StackRoomListAdapter(new ArrayList<StackRoom>());
        stackRoomListAdapter.addOnClickListener(new StackRoomCardListener());

        roomsList.setHasFixedSize(true);
        roomsList.setLayoutManager(new LinearLayoutManager(getActivity()));

        roomsList.setAdapter(stackRoomListAdapter);
    }

    @Override
    public void onRetrievedRooms(ArrayList<StackRoom> rooms) {
        stackRoomListAdapter.setStackRooms(rooms);
        stackRoomListAdapter.notifyDataSetChanged();
    }
}
