package com.example.kfc36_000.napp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class TimerInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText timerText = (EditText)findViewById(R.id.timerText);
        final EditText timeToSleep = (EditText) findViewById(R.id.timeToSleepText);
        ImageButton start = (ImageButton) findViewById(R.id.startButton);
        Typeface roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        timerText.setTypeface(roboto);
        timeToSleep.setTypeface(roboto);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = timerText.getText().toString();
                String timeTill = timeToSleep.getText().toString();
                Intent i = new Intent(TimerInput.this, MainActivity.class);
                i.putExtra("timeForSleep",time);
                i.putExtra("timeTillSleep", timeTill);
                startActivity(i);
            }
        });
    }

}
