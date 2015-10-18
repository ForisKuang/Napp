package com.example.kfc36_000.napp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.provider.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int MINUTES_TO_MILLIS = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarm == null) {
            alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        final Ringtone alert = RingtoneManager.getRingtone(getApplicationContext(), alarm);
        Intent intent = getIntent();
        final ImageButton stopButton = (ImageButton) findViewById(R.id.stopButton);
        // Grabs the values from TimerInput for time for sleep and time till sleep
        String time = intent.getExtras().getString("timeForSleep");
        String timeTillSleep = intent.getExtras().getString("timeTillSleep");
        final int timeInMinutes = (convertTimeToSeconds(time)-convertTimeToSeconds(timeTillSleep))/60; // converts both to ints and then converts to mins
        final TextView tx = (TextView)findViewById(R.id.timerText);
        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        tx.setTypeface(roboto);
        /*
        Firebase firebase = new Firebase();
        int[] stageOneValues = firebase.getSleepArray();

        for(int i = 0; i < stageOneValues.length-1; i++) {
            if(stageOneValues[i] < timeInMinutes && stageOneValues[i+1] > timeInMinutes) {
                timeInMinutes = stageOneValues[i];
                break;
            }
        }

         */

        long timeInMillis = timeInMinutes*MINUTES_TO_MILLIS;
        new CountDownTimer(timeInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                String hours = Integer.toString((int) (millisUntilFinished/3600000));
                if(hours.equals("0")) {
                    hours = "00";
                }
                millisUntilFinished-= (int) (millisUntilFinished/3600000);
                String minutes = Integer.toString((int)millisUntilFinished/60000);
                if(minutes.equals("0")) {
                    minutes = "00";
                }
                millisUntilFinished-=(int) (millisUntilFinished/60000);
                String seconds = Integer.toString((int)millisUntilFinished/1000);
                if(seconds.equals("0")) {
                    seconds = "00";
                }
                String hoursMinutesSeconds = hours + "  :  " + minutes + "  :  " + seconds;
                tx.setText(hoursMinutesSeconds);
            }

            public void onFinish() {
                tx.setText("00 00 00");
                alert.play();
                stopButton.setVisibility(View.VISIBLE);
            }
        }.start();

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.stop();
                Intent finish = new Intent(MainActivity.this,FeelingsActivity.class);
                finish.putExtra("sleepTime", timeInMinutes);
                startActivity(finish);
            }
        });
    }

    private int convertTimeToSeconds(String time) {
        String[] timeValues = time.split("  :  ");
        int totalTime = 0;
        for(int i = 0; i < timeValues.length; i++){
            totalTime += Integer.parseInt(timeValues[i]) * (Math.pow(60, timeValues.length - 1 - i));
        }
        return totalTime;
    }
}
