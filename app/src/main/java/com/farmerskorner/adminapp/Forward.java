package com.farmerskorner.adminapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Forward extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward);
    }
    public void myintent(Context context){
        Intent i1=new Intent(context,SuggestionData.class);
        startActivity(i1);
    }
}
