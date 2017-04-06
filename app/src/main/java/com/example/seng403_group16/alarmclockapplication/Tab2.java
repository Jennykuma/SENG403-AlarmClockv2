package com.example.seng403_group16.alarmclockapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.TimePicker;

import java.io.*;
import java.util.Calendar;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * Created by Jennykuma on 2017-04-05.
 */

public class Tab2 extends Fragment implements View.OnClickListener {

    View view;
    private TimePicker timePicker;
    private Button createAlarm;
    private Calendar calendar;
    private String format = "";
    private TextView time;

    BufferedWriter bw = null;
    FileWriter fw = null;

    int hour;
    int min;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab2, container, false);
        createAlarm = (Button) view.findViewById(R.id.setAlarm);
        createAlarm.setOnClickListener(this);
        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        hour = timePicker.getCurrentHour();
        min = timePicker.getCurrentMinute();
        try {
            String filePath = this.getContext().getFilesDir().getPath().toString() + "/alarms.txt";
            File output = new File(filePath);
            if(!output.exists()){
                output.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(output,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.append(hour + " " + min + "\n");
            Toast.makeText(getActivity(), "Hour: " + hour + "  Min: " + min, Toast.LENGTH_LONG).show();
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException g){
            Toast.makeText(this.getActivity(), "YOU DUN GOOFED" + g, Toast.LENGTH_SHORT).show();
        }
    }
}