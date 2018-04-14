package com.example.abdullah.homeautomation;

import android.app.Activity;
import android.content.Context;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{

    Intent intent;
    Bluetooth_Class bt;
    public TimePickerFragment( ) {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        int hour = 0;
        int minute = 0;

        Log.e("","in time fragment class onCreateDialog method");
        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void setBluetooth(Bluetooth_Class bluetooth){
        Log.e("","in time fragment class setBluetooth method before setting bt");
        bt=bluetooth;
        Log.e("","in time fragment class setBluetooth method after seting bt");
    }
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //startService(intent);
        Log.e("","in time fragment class on time set method");
        //bt.sendData("0");
        //Log.e("","in time fragment class on time set method data send successfully");
    }

}
