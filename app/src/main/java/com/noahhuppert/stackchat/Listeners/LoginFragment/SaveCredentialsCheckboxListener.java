package com.noahhuppert.stackchat.Listeners.LoginFragment;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class SaveCredentialsCheckboxListener implements CompoundButton.OnCheckedChangeListener {
    TextView saveCredentialsWarning;

    public SaveCredentialsCheckboxListener(TextView saveCredentialsWarning){
        this.saveCredentialsWarning = saveCredentialsWarning;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            saveCredentialsWarning.setVisibility(View.VISIBLE);
        } else{
            saveCredentialsWarning.setVisibility(View.INVISIBLE);
        }
    }
}
