package com.example.literacyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.literacyapp.R;

public class NumbersExerciseActivity extends AppCompatActivity {
    MediaPlayer correct;
    MediaPlayer wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers_exercise_activity);
        correct = MediaPlayer.create(this, R.raw.correctanswer);
        wrong = MediaPlayer.create(this, R.raw.wronganswer);
    }

    public void backward(View view) {
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }
}
