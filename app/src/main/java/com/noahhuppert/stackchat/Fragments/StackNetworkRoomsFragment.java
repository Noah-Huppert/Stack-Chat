package com.noahhuppert.stackchat.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Interfaces.InterfaceHelper;
import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class StackNetworkRoomsFragment extends Fragment {
    public static final String BUNDLE_SELECTED_NETWORK_KEY = "BUNDLE_SELECTED_NETWORK_KEY";
    private FragmentToActivityBus fragmentToActivityBus;

    private int selectedNetworkKey;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.stack_network_rooms_fragment, container, false);
        TextView stackNetworkName = (TextView) rootView.findViewById(R.id.stack_network_rooms_network_name);

        selectedNetworkKey = getArguments().getInt(BUNDLE_SELECTED_NETWORK_KEY);

        stackNetworkName.setText(fragmentToActivityBus.getStackNetworks().get(selectedNetworkKey).getName());

        //TODO Parse StackNetwork url for rooms
        //TODO Create real layout with RecyclerView of rooms

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentToActivityBus = (FragmentToActivityBus) InterfaceHelper.attachToActivity(FragmentToActivityBus.class, activity);
    }
}
