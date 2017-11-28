package com.example.mariusz.notificationreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MAIN_ACTIVITY", "SERVICE Started");
        Intent serviceIntent = new Intent(this, MyNotificationService.class);
        startService(serviceIntent);
        Toast.makeText(this, "SERVICE Started", Toast.LENGTH_LONG).show();
        Log.d("MAIN_ACTIVITY", "SERVICE Started");

    }


}
