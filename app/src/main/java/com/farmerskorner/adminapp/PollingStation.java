package com.farmerskorner.adminapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PollingStation extends AppCompatActivity {
    private static final String MyPREFERENCES = "MyPref";
    public static final String Name = "nameKey";
    SharedPreferences sharedpreferences;
    public static String boothid;
    public String staticName;
    TextView boothName1;
    EditText number;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_station);
        boothName1=findViewById(R.id.boothName);
        staticName = boothName.name;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        boothName1.setText(staticName);
        number=findViewById(R.id.number);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people p = new people(getApplicationContext());
                p.execute(boothid,number.getText().toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
