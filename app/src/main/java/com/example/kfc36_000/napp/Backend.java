package com.example.kfc36_000.napp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Scanner;

/**
 * Created by kfc36_000 on 10/17/2015.
 */
public class Backend {

    public static final int[] initialStageOne = {15, 105, 195, 285, 375, 465, 555};
    public int timeAvailable;


    public Backend() {

    }
    public int convertToSeconds(String time) {
        String[] timeValues = time.split(":");
        int totalSeconds = 0;
        for(int i = 0; i < timeValues.length; i++) {
            int tValue = Integer.parseInt(timeValues[i]);
            totalSeconds += tValue * (Math.pow(60, (timeValues.length - 1) - i));
        }
        return totalSeconds;
    }




}
