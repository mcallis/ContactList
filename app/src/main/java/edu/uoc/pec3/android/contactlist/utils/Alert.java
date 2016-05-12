package edu.uoc.pec3.android.contactlist.utils;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Marc on 12/5/16.
 */
public class Alert {

    public static void show(Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("Agree", null);
        builder.show();
    }
}
