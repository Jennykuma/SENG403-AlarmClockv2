package com.example.seng403_group16.alarmclockapplication;

/**
 * Created by Jennykuma on 2017-04-05.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.*;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context k1, Intent k2) {
        // TODO Auto-generated method stub
        String filePath = k1.getFilesDir().getPath().toString() + "/alarms.txt";
        File savedAlarms = new File(filePath);
        if(savedAlarms.exists()){
            Toast.makeText(k1, "Alarm received!", Toast.LENGTH_LONG).show();
        }
    }

}