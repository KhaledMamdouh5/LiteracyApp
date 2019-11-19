package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN80 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n80);
    }

    public void backwardn80(View view) {

    }

    public void forwardn80(View view) {
        OpenActivityN90();
    }
    public void OpenActivityN90(){
        Intent openactivityn90 = new Intent(this, ActivityN90.class);
        startActivity(openactivityn90);
    }

    public void number80(View view) {
    }
}
