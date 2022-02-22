package com.alexanderbehrhof.myyearbook;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class MyYearbook extends Application {

    private static boolean activityVisible;
    private final AtomicInteger notificationId = new AtomicInteger(0);
    private static MyYearbook instance;

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
        instance = this;
    }

    /**
     * return the MyYearbook notification
     *
     * @return the MyYearbook app
     */
    public static MyYearbook getInstance() {
        return instance;
    }

    /**
     * Creates the notification channel
     */
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    /**
     * Controls if the activity is currently visible or not
     *
     * @return the current status of the activity
     */
    public static boolean isActivityVisible() {
        return activityVisible;
    }

    /**
     * Controls if the activity should be visible or not
     *
     * @param activityVisible the current visibility status of the activity
     */
    public static void setActivityVisible(boolean activityVisible) {
        MyYearbook.activityVisible = activityVisible;
    }

    /**
     * Sets that the activity has been resumed
     */
    public static void resumeActivity() {
        setActivityVisible(true);
    }

    /**
     * Sets that the activity has been paused
     */
    public static void pauseActivity() {
        setActivityVisible(false);
    }

    /**
     * Sends a notification after the given time to the user.
     *
     * @param ctx               the class context
     * @param activityToOpen    the activity to open when the user selects the activity
     * @param millisIn          the amount of seconds to wait (in milliseconds)
     * @param countDownInterval the count-down interval in milliseconds
     */
    public void pushNotificationAfterGivenTime(Context ctx, Class<?> activityToOpen, long millisIn, long countDownInterval) {
        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(ctx, activityToOpen);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx, "CHANNEL_ID")
            .setSmallIcon(R.drawable.sjcny_logo)
            .setContentTitle(getString(R.string.notification_title))
            .setContentText(getString(R.string.notification_text))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(resultPendingIntent)
            .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(ctx);

        CountDownTimer timer = new CountDownTimer(millisIn, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                // App is ticking down
            }

            @Override
            public void onFinish() {
                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(notificationId.incrementAndGet(), builder.build());
            }

        }.start();
    }
}
