package com.example.mariusz.notificationreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NotificationSendBackActivity extends AppCompatActivity {

    private static final String TAG = "NotificationSendBackActivity";
    public static final String INTENT_ACTION_NAME = "com.example.mariusz.MY_NOTIFICATION";
    public static final String NOTIFICATION_MEASSAGE_KEY = "notificationMessage";
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_sender);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = String.valueOf(editText.getText());
                Intent notificationIntent = new Intent();
                notificationIntent.setAction(INTENT_ACTION_NAME);
                notificationIntent.putExtra(NOTIFICATION_MEASSAGE_KEY, message);
                notificationIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                Toast.makeText(getApplicationContext(), "message sent: " +
                        editText.getText(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "message sent: " +editText.getText());
                sendBroadcast(notificationIntent);
            }
        });
    }
}
