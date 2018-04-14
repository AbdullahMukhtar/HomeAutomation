package com.example.abdullah.homeautomation;

/**
 * Created by Abdul on 4/1/2018.
 */

public class Bluetooth_Device {
    private String name;
    private String address;

    public Bluetooth_Device(String name,String address){
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
