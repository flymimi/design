package com.example.noti2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final  int FLAG =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder notifiy =new Notification.Builder(MainActivity.this);
        notifiy.setSmallIcon(R.drawable.icon4);
        notifiy.setAutoCancel(true);
        notifiy.setContentTitle("您有一个小裙子未领取");
        notifiy.setContentText("点击即可领取");
        notifiy.setWhen(System.currentTimeMillis());
        notifiy.setDefaults(Notification.DEFAULT_SOUND);
        Intent intent =new Intent(MainActivity.this,Main2Activity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity.this,0,intent,0);
        notifiy.setContentIntent(pendingIntent);
        notificationManager.notify(FLAG,notifiy.build());

    }
}
