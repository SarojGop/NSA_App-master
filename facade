package com.example.nsa;

import android.location.LocationManager;

public class Facade extends location{
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    LocationManager locationManager;
    String provider;
    location currentlocaiton = new location();

    public location getCurrentlocaiton() {
        checkLocationPermission();
        return currentlocaiton;
    }
}
