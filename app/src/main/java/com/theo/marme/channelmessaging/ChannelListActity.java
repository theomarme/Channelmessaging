package com.theo.marme.channelmessaging;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by marmet on 23/01/2017.
 */
public class ChannelListActity extends AppCompatActivity implements Async.OnDownloadCompleteListener,AdapterView.OnItemClickListener{

    public static final String PREFS_NAME = "stockage";
    private ListView lvChannels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String accestoken = settings.getString("accesstoken","");

        HashMap<String,String> connectInfo = new HashMap<>();
        connectInfo.put("accesstoken",accestoken);

        Async d = new Async(this,"http://www.raphaelbischof.fr/messaging/?function=getchannels",connectInfo);
        d.addOnDownloadCompleteListener(this);
        d.execute();
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onDownloadComplete(String result) {

        Gson gson = new Gson();
        Channels c = gson.fromJson(result, Channels.class);

        for(Channel ch :c.channels){
            Toast.makeText(this, ch.name, Toast.LENGTH_SHORT).show();
        }

        lvChannels = (ListView) findViewById(R.id.lv_id);
        lvChannels.setAdapter(new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, c.channels));
        lvChannels.setOnItemClickListener(this);
    }
}
