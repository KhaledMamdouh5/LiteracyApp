package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityZero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

    }

    public void number0(View view) {

    }

    public void forwardn0(View view) {
        OpenActivityN1_10();
    }
    public void OpenActivityN1_10(){
        Intent openactivityn1_10 = new Intent(this, ActivityN1_10.class);
        startActivity(openactivityn1_10);
    }

    public void onBackPressed(){
        OpenActivityStarting();
    }

    public void OpenActivityStarting(){
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }
}
