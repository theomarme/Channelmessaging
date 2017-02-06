package com.theo.marme.channelmessaging;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by marmet on 06/02/2017.
 */
public class MessageListActivit extends AppCompatActivity implements View.OnClickListener,Async.OnDownloadCompleteListener,AdapterView.OnItemClickListener {

    private ListView lvMessage;
    private Button btnSend;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_layout);

        lvMessage = (ListView) findViewById(R.id.lv_id);
        lvMessage.setOnItemClickListener(this);
        btnSend= (Button) findViewById(R.id.id_send);
        btnSend.setOnClickListener(this);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String accestoken = settings.getString("accesstoken","");

        HashMap<String,String> params = new HashMap<>();
        params.put("accesstoken",accestoken);

        Async d = new Async(this,"http://www.raphaelbischof.fr/messaging/?function=getmessages",params);
        d.addOnDownloadCompleteListener(this);
        d.execute();
    }

    @Override
    public void onDownloadComplete(String content) {

        Gson gson = new Gson();
        MessageList c = gson.fromJson(content, MessageList.class);

        for(Message ch :c.message){
            Toast.makeText(this, ch.message, Toast.LENGTH_SHORT).show();
        }

        lvMessage = (ListView) findViewById(R.id.lv_message);
        lvMessage.setAdapter(new MessageListAdapter(getApplicationContext(), c.message));
        lvMessage.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {

    }
}
