package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN40 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n40);
    }

    public void forwardn40(View view) {
        OpenActivityN50();
    }
    public void OpenActivityN50(){
        Intent openactivityn50 = new Intent(this, ActivityN50.class);
        startActivity(openactivityn50);
    }

    public void backwardn40(View view) {
    }

    public void number40(View view) {
    }
}
