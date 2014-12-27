package com.noahhuppert.stackchat.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Interfaces.InterfaceHelper;
import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 12/27/2014.
 */
public class BaseFragment extends Fragment {
    protected FragmentToActivityBus fragmentToActivityBus;
    protected int fragmentLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(fragmentLayout, container, false);

        runOnCreateView(inflater, container, savedInstanceState, rootView);

        return rootView;
    }

    public void runOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentToActivityBus = (FragmentToActivityBus) InterfaceHelper.attachToActivity(FragmentToActivityBus.class, activity);
    }
}
