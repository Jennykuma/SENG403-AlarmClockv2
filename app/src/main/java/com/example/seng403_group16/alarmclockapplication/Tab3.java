package com.example.seng403_group16.alarmclockapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;


import java.util.List;

/**
 * Created by Jennykuma on 2017-04-05.
 */

import android.util.Log;

public class Tab3 extends Fragment{

    public static ArrayList<String> alarms = new ArrayList<String>();

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            //String filePath = this.getContext().getFilesDir().getPath().toString() + "/alarms.txt";
            InputStream inputStream = this.getContext().openFileInput("alarms.txt");
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    alarms.add(receiveString);
                }

                inputStream.close();

            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        /* WHYY ISNT IT SHOWING IN THE LISTVIEW
        ListView listView1 = (ListView) getView().findViewById(R.id.alarm_List);
        String[] items = new String[1];
        //Comment this out later yo
        for(int i = 0; i < alarms.size(); i++){
            System.out.println("ArrayList: " + alarms.get(i));
            items[i] = alarms.get(i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listView1.getContext(),
                android.R.layout.simple_list_item_1, alarms);

        listView1.setAdapter(adapter);*/

        // ONCLICK CODE FOR CANCEL BUTTON - Matteo Molnar
        final View view = inflater.inflate(R.layout.tab3, container, false);
        final View button = view.findViewById(R.id.CancelButton);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String filePath = getContext().getFilesDir().getPath().toString() + "/alarms.txt";
                        File savedAlarms = new File(filePath);
                        if(!savedAlarms.exists()){
                            Toast.makeText(getContext(), "No alarms are set to cancel", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            savedAlarms.delete();
                            Toast.makeText(getContext(), "Alarm has been cancelled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        return view;
    }

}
