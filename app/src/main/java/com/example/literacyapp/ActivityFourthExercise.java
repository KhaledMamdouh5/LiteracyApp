package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityFourthExercise extends AppCompatActivity {
int [] wordImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_exercise);

        wordImage = new int[] {R.drawable.dates, R.drawable.horse};
    }
}
