package com.theo.marme.channelmessaging;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;

/**
 * Created by marmet on 23/01/2017.
 */
public class ChannelListActity extends AppCompatActivity implements {

    public static final String PREFS_NAME = "stockage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String accestoken = settings.getString("accestoken","");

        HashMap<String,String> connectInfo = new HashMap<>();
        connectInfo.put("accestoken",accestoken);

        Async d = new Async(this,"http://www.raphaelbischof.fr/messaging/?function=getchannels",connectInfo);
        d.setOnDownloadCompleteListener(this);
        d.execute();

    }
}
