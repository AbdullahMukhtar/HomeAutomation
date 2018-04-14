package com.example.abdullah.homeautomation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by Abdul on 4/2/2018.
 */

public class CustomAddapter extends ArrayAdapter {
    private ArrayList<Bluetooth_Device> devices_List;
    public CustomAddapter(@NonNull Context context, ArrayList<Bluetooth_Device> devices_List) {
        super(context, 0,devices_List);
        this.devices_List = devices_List;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.devices_list,parent,false);
        }else{
            view = convertView;
        }
        Bluetooth_Device device = devices_List.get(position);
        TextView nameTxt = (TextView) view.findViewById(R.id.name);
        TextView addressTxt = (TextView) view.findViewById(R.id.address);
        nameTxt.setText(device.getName());
        addressTxt.setText(device.getAddress());
        return view;
    }
}
