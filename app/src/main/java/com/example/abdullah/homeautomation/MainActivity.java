package com.example.abdullah.homeautomation;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button switch1, switch2,switch3,switch4;
    private BluetoothAdapter btAdapter = null;
    ArrayList<Bluetooth_Device> devices_List;
    String macAddress ;
    Bluetooth_Class bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1=(Button) findViewById(R.id.switch1);
        switch2=(Button) findViewById(R.id.switch2);
        switch3=(Button) findViewById(R.id.switch3);
        switch4=(Button) findViewById(R.id.switch4);
        btAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
        devices_List = new ArrayList<Bluetooth_Device>();
        for(BluetoothDevice bt : pairedDevices)
            devices_List.add(new Bluetooth_Device(bt.getName(),bt.getAddress()));

        ListView listView = (ListView) findViewById(R.id.BTList);
        CustomAddapter customAdapter = new CustomAddapter(this,devices_List);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                macAddress=devices_List.get(position).getAddress();
                Toast.makeText(MainActivity.this,macAddress,Toast.LENGTH_SHORT).show();
                bt=new Bluetooth_Class(macAddress);
            }
        });
        startService(new Intent(this,MyService.class));
        switch1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bt.sendData("0");
                Toast.makeText(getBaseContext(), "Turn on LED", Toast.LENGTH_SHORT).show();
            }
        });
        switch2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bt.sendData("1");
                Toast.makeText(getBaseContext(), "Turn on LED", Toast.LENGTH_SHORT).show();
            }
        });
        switch3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bt.sendData("2");
                Toast.makeText(getBaseContext(), "Turn on LED", Toast.LENGTH_SHORT).show();
            }
        });
        switch4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bt.sendData("3");
                Toast.makeText(getBaseContext(), "Turn on LED", Toast.LENGTH_SHORT).show();
            }
        });
    }


}