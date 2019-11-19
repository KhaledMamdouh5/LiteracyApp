package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ActivityMentor extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelMenter> modelMenter;
    AdapterMenter adapterMenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        recyclerView = findViewById(R.id.recycler_view);
    }
}
