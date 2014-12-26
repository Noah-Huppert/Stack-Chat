package com.noahhuppert.stackchat.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.noahhuppert.stackchat.R;

/**
 * Created by Noah Huppert on 12/25/2014.
 */
public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        //Show Save Credentials warning
        CheckBox saveCredentialsCheckbox = (CheckBox) rootView.findViewById(R.id.login_fragment_save_credentials);
        final TextView saveCredentialsWarning = (TextView) rootView.findViewById(R.id.login_fragment_save_credentials_warning);

        saveCredentialsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    saveCredentialsWarning.setVisibility(View.VISIBLE);
                } else{
                    saveCredentialsWarning.setVisibility(View.INVISIBLE);
                }
            }
        });

        return rootView;
    }
}
