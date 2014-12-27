package com.noahhuppert.stackchat;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.crashlytics.android.Crashlytics;
import com.noahhuppert.stackchat.Fragments.LoginFragment;
import com.noahhuppert.stackchat.Fragments.SelectStackNetworkFragment;
import com.noahhuppert.stackchat.Fragments.StackNetworkRoomsFragment;
import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Models.StackNetwork;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends ActionBarActivity implements FragmentToActivityBus{
    public static final String FRAGMENT_LOGIN = "FRAGMENT_LOGIN";
    public static final String FRAGMENT_SELECT_STACK_NETWORK = "FRAGMENT_SELECT_STACK_NETWORK";
    public static final String FRAGMENT_STACK_NETWORK_ROOMS = "FRAGMENT_STACK_NETWORK_ROOMS";

    public ArrayList<StackNetwork> stackNetworks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        FrameLayout mainFragment = (FrameLayout) findViewById(R.id.mainFragment);
        switchFragment(FRAGMENT_LOGIN);

        //Set Toolbar as actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

        //Set data
        stackNetworks = new ArrayList<StackNetwork>();
        stackNetworks.add(new StackNetwork("Stack Exchange", "http://chat.stackexchange.com/", R.drawable.se_icon));
        stackNetworks.add(new StackNetwork("Stack Overflow", "http://chat.stackoverflow.com/", R.drawable.ic_launcher));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void switchFragment(String fragmentId, Bundle data){
        Fragment fragment = null;

        if(fragmentId.equals(FRAGMENT_LOGIN)){
            fragment = new LoginFragment();
        } else if(fragmentId.equals(FRAGMENT_SELECT_STACK_NETWORK)){
            fragment = new SelectStackNetworkFragment();
        } else if(fragmentId.equals(FRAGMENT_STACK_NETWORK_ROOMS)){
            fragment = new StackNetworkRoomsFragment();
        }

        if(fragment != null){
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            if(data != null){
                fragment.setArguments(data);
            }

            fragmentTransaction.replace(R.id.mainFragment, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void switchFragment(String fragmentId){
        switchFragment(fragmentId, null);
    }

    @Override
    public ArrayList<StackNetwork> getStackNetworks(){
        return stackNetworks;
    }
}
