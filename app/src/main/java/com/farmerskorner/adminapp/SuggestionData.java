package com.farmerskorner.adminapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SuggestionData extends AppCompatActivity {

    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_data);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        FeedbackData feedbackData = new FeedbackData(this,recyclerView);
        feedbackData.execute();
    }
}
