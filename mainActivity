package com.example.nsa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(getApplicationContext(), loginActivity.class);
        startActivity(i);
        Facade newcurrent = new Facade();
        newcurrent.getCurrentlocaiton();
        location checkrequest = new location();
        onRequestPermissionsResult(checkrequest.getRequestedOrientation(),checkrequest.databaseList(),null);
        Intent i = new Intent(getApplicationContext(), loginActivity.class);
        startActivity(i);
           }
