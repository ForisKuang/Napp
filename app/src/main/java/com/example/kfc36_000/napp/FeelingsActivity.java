package com.example.kfc36_000.napp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class FeelingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feelings);
        ImageButton groggy = (ImageButton) findViewById(R.id.groggy);
        ImageButton refreshed = (ImageButton) findViewById(R.id.refreshed);
        ImageButton feelBetter = (ImageButton) findViewById(R.id.feelBetter);
        ImageButton disoriented = (ImageButton) findViewById(R.id.disoriented);

        groggy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                connectBackToHome();
            }
        });

        refreshed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connectBackToHome();
            }
        });

        feelBetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connectBackToHome();
            }
        });

        disoriented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connectBackToHome();
            }
        });

    }

    protected void connectBackToHome() {
        Intent intent = new Intent(FeelingsActivity.this,TimerInput.class);
        startActivity(intent);
    }

}
