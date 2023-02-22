package com.example.practical5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.widget.Button;

import java.util.PriorityQueue;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.SendNotification)
    Button btn;
    @BindView(R.id.SendNotificationWithIcon)
    Button btn2;


    @BindView(R.id.SendNotificationHandsUp)
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        //Simple Notification
        int notify_ID=1;
        String CHANNEL_ID = "my_channel_id";
        NotificationManager mnotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification;

        notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("New Message")
                    .setContentText("You received a new notification")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .build();

        mnotificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel", NotificationManager.IMPORTANCE_HIGH));


        //Notification with LargeIcon, SmallIcon, Date/Time, Badge
        int notify_ID2=2;
        String CHANNEL_ID2 = "my_channel_id";
        NotificationManager mnotificationManager2 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification2=
                new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("New Message")
                .setContentText("You received a new notification")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.playstore))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();

        //Show Head Up Notification

        int notify_ID3 = 3;
        String CHANNEL_ID3 = "my_channel_id";
        NotificationManager mnotificationManager3 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification3 = new Notification.Builder(this, CHANNEL_ID3)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Title")
                .setContentText("This is the text of the notification")
                .setPriority(Notification.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setFullScreenIntent(pendingIntent,true)
                .build();




















        btn.setOnClickListener(v->{
            mnotificationManager.notify(notify_ID, notification);
        });


        btn2.setOnClickListener(v->{
            mnotificationManager2.notify(notify_ID2,notification2);
        });


        btn3.setOnClickListener(v->{
            mnotificationManager3.notify(notify_ID3,notification3);
        });

    }
}