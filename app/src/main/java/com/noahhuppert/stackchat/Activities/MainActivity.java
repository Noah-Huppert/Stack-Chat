package com.noahhuppert.stackchat.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.crashlytics.android.Crashlytics;
import com.noahhuppert.stackchat.BuildConfig;
import com.noahhuppert.stackchat.Fragments.LoginFragment;
import com.noahhuppert.stackchat.Fragments.NavigationDrawerFragment;
import com.noahhuppert.stackchat.Fragments.SelectStackNetworkFragment;
import com.noahhuppert.stackchat.Fragments.StackNetworkRoomsFragment;
import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Listeners.NavigationDrawer.NavigationDrawerToggleListener;
import com.noahhuppert.stackchat.Models.StackNetwork;
import com.noahhuppert.stackchat.R;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends ActionBarActivity implements FragmentToActivityBus{
    public static final String FRAGMENT_LOGIN = "FRAGMENT_LOGIN";
    public static final String FRAGMENT_SELECT_STACK_NETWORK = "FRAGMENT_SELECT_STACK_NETWORK";
    public static final String FRAGMENT_STACK_NETWORK_ROOMS = "FRAGMENT_STACK_NETWORK_ROOMS";

    public ArrayList<StackNetwork> stackNetworks;

    private DrawerLayout drawerLayout;
    private NavigationDrawerToggleListener navigationDrawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Only start Crashlytics if not in Debug mode
        if(!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

        setContentView(R.layout.activity_main);

        //Set Toolbar as actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

        //Setup navigation drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);

        navigationDrawerListener = new NavigationDrawerToggleListener(this, drawerLayout, toolbar);
        drawerLayout.setDrawerListener(navigationDrawerListener);

        getFragmentManager().beginTransaction().replace(R.id.navigation_drawer_fragment, new NavigationDrawerFragment()).addToBackStack(null).commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationDrawerListener.syncState();

        //Set data
        stackNetworks = new ArrayList<StackNetwork>();
        stackNetworks.add(new StackNetwork("Stack Exchange", "http://chat.stackexchange.com/", R.drawable.se_icon));
        stackNetworks.add(new StackNetwork("Stack Overflow", "http://chat.stackoverflow.com/", R.drawable.so_icon));

        switchFragment(FRAGMENT_LOGIN);
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

            fragmentTransaction.replace(R.id.main_fragment, fragment);
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

    @Override
    public void setShowActionBarToggle(boolean show) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(show);
        getSupportActionBar().setHomeButtonEnabled(show);

        if(show){
            drawerLayout.setDrawerLockMode(0, Gravity.START);
            navigationDrawerListener.syncState();
        } else{
            drawerLayout.setDrawerLockMode(1, Gravity.START);
        }
    }
}
