package com.example.mariusz.notificationreceiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyNotificationReceiver extends BroadcastReceiver {

    public static final String MY_NOTIFICATION_CHANNEL_ID = "myChannleId";
    public static final String MY_NOTIFICATION_CHANNEL_NAME = "myChannel";
    private static final String TAG = "MyNotificationReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String receivedMessage = intent.getStringExtra("notificationMessage");
        Log.d(TAG, "Message received: " + receivedMessage);
        displayNotification(context, receivedMessage);
    }

    private void displayNotification(Context context, String notificationText) {
        Log.d(TAG, "about to display notification: " + notificationText);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
                context, MY_NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_stat_adb)
                .setContentTitle("My Notification")
                .setContentText(notificationText);
        Intent resultIntent = new Intent(context, NotificationSendBackActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(NotificationSendBackActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager = (NotificationManager)context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100, notificationBuilder.build());
    }
}
