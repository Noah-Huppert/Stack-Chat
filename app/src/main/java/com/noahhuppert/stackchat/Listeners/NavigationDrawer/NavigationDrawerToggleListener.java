package com.noahhuppert.stackchat.Listeners.NavigationDrawer;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public class NavigationDrawerToggleListener extends ActionBarDrawerToggle {
    public NavigationDrawerToggleListener(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar) {
        super(activity, drawerLayout, toolbar, R.string.navigation_drawer_open_description, R.string.navigation_drawer_close_description);
    }
}
