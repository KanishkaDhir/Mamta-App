package com.hackathon.missionindradhanush;

import android.annotation.TargetApi;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


public class notificationhelper extends ContextWrapper {
    String ch1 = "ch1";
    CharSequence name = getString(R.string.channel_name);
    String description = getString(R.string.channel_description);

    private NotificationManager notificationManager=null;

    public notificationhelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createchannels();
    }}

    @TargetApi(Build.VERSION_CODES.O)
    private void createchannels() {

            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library

            NotificationChannel channel = new NotificationChannel(ch1, name, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(description);
        getmanager().createNotificationChannel(channel);


}
public NotificationManager getmanager()
{   if(notificationManager==null) {
    notificationManager = (NotificationManager) getSystemService(
            NOTIFICATION_SERVICE);
}

    return notificationManager;
}

    NotificationCompat.Builder getnotification() {

        Intent intent = new Intent(this, AlertDialog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        return new NotificationCompat.Builder(getApplicationContext(), ch1)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("hello world")

                .setContentText("this is what u see")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

    }

}
