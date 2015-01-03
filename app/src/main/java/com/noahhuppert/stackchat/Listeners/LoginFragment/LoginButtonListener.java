package com.noahhuppert.stackchat.Listeners.LoginFragment;

import android.view.View;

import com.noahhuppert.stackchat.Interfaces.FragmentToActivityBus;
import com.noahhuppert.stackchat.Activities.MainActivity;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class LoginButtonListener implements View.OnClickListener {
    private FragmentToActivityBus fragmentToActivityBus;

    public LoginButtonListener(FragmentToActivityBus fragmentToActivityBus){
        this.fragmentToActivityBus = fragmentToActivityBus;
    }

    @Override
    public void onClick(View view){
        fragmentToActivityBus.setShowActionBarToggle(true);
        fragmentToActivityBus.switchFragment(MainActivity.FRAGMENT_SELECT_STACK_NETWORK);
    }
}
