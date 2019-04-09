package com.farmerskorner.adminapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PollingStation extends AppCompatActivity {
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
//        Toast.makeText(this, "Name"+ staticName, Toast.LENGTH_SHORT).show();
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
}
