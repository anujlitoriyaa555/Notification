package com.example.notification;


import  android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    NotificationCompat.Builder notification ;
    private static final int uniqueID = 23213;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);


    }

    public void  anujsButtonClicked(View view){

        // build the notification

        notification.setSmallIcon(R.drawable.ic_launcher_foreground);
        notification.setTicker("this is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("this the title ");
        notification.setContentText("this is the content of your notification");


        Intent intent = new Intent(this,MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        // builds a notification and issue it

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());



    }
}
