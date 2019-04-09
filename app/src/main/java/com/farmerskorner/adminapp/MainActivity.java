package com.farmerskorner.adminapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=(Button)findViewById(R.id.logInButton);
        userName= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login login = new Login(getApplicationContext());
                String uname = userName.getText().toString();
                String pass = password.getText().toString();
                login.execute(uname,pass);
            }
        });

    }



}
