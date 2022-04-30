package com.hackathon.missionindradhanush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


public class snotification extends BroadcastReceiver{
    @Override


    public void onReceive(Context context, Intent t) {
        com.hackathon.missionindradhanush.notificationhelper notificationhelper=new notificationhelper(context);
        NotificationCompat.Builder nb=notificationhelper.getnotification();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(notificationhelper);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, nb.build());
    }
}
