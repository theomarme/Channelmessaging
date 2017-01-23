package com.theo.marme.channelmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnValider;
    private TextView tvmotdepasse;
    private TextView tvIdentifiant;
    private EditText etIdentifiant;
    private EditText etmotdepasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnValider = (Button) findViewById(R.id.bt_id);
        btnValider.setOnClickListener(this);

        tvIdentifiant = (TextView) findViewById(R.id.tv_id1);
        tvmotdepasse = (TextView) findViewById(R.id.tv_id2);

        etIdentifiant = (EditText) findViewById(R.id.et_id1);
        etmotdepasse = (EditText) findViewById(R.id.et_id2);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_id)
        {
            HashMap<String, String> connectInfo = new HashMap<>();
            connectInfo.put("id",etIdentifiant.getText().toString());
            connectInfo.put("mdp", etmotdepasse.getText().toString());
            Async Async = new Async(getApplicationContext(), connectInfo);
            Async.setOnDownloadCompleteListener((OnDownloadCompleteListener) this);
            Async.execute();
        }
    }

    @Override
    public void onDownloadComplete(String result) {

        Gson gson = new Gson();
        Callback obj = new Callback();
        String json = gson.toJson(obj);

    }



}

