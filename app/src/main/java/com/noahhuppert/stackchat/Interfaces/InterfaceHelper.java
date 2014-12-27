package com.noahhuppert.stackchat.Interfaces;

import android.app.Activity;

/**
 * Created by Noah Huppert on 12/26/2014.
 */
public class InterfaceHelper {
    public static Object attachToActivity(Class<?> interfaceClass, Activity activity){
        try{
            return interfaceClass.cast(activity);
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement " + interfaceClass.getName());
        }
    }
}
