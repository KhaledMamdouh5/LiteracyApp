package com.example.literacyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.literacyapp.R;

public class ZeroActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zero_activity);
        mediaPlayer = MediaPlayer.create(this,R.raw.zero);
}

    public void number0(View view) {
        mediaPlayer.start();
    }

    public void forwardn0(View view) {
        OpenActivityN1_10();
    }

    public void OpenActivityN1_10() {
        Intent openactivityn1_10 = new Intent(this, ActivityN1_10.class);
        startActivity(openactivityn1_10);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }
}
