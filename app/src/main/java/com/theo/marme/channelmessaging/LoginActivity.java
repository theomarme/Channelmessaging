package com.theo.marme.channelmessaging;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,OnDownloadCompleteListener{

    public static final String PREFS_NAME = "stockage";
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
        HashMap<String,String> connectInfo = new HashMap<String, String>();
        connectInfo.put("username", etIdentifiant.getText().toString());
        connectInfo.put("password", etmotdepasse.getText().toString());
        if (v.getId() == R.id.bt_id) {
            String Login = String.valueOf(etIdentifiant.getText());
            String Pwd = String.valueOf(etmotdepasse.getText());
            Async d = new Async(this,"http://www.raphaelbischof.fr/messaging/?function=connect",connectInfo);
            d.setOnDownloadCompleteListener(this);
            d.execute();
        }
    }

    @Override
    public void onDownloadComplete(String result) {

        Gson gson = new Gson();

        Callback r = gson.fromJson(result, Callback.class);
        if(r.code==200){
            Toast.makeText(this, "Vous êtes connecté ! ", Toast.LENGTH_SHORT).show();
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("accesstoken", r.accesstokens);

            Intent appel = new Intent(getApplicationContext(),ChannelListActity.class);
            startActivity(appel);
        }
        else{
            Toast.makeText(this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
        }
    }

}

