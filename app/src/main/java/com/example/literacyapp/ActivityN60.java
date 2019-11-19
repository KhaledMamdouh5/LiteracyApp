package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN60 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n60);
    }

    public void forwardn60(View view) {
        OpenActivityN70();
    }
    public void OpenActivityN70(){
        Intent openactivityn70 = new Intent(this, ActivityN70.class);
        startActivity(openactivityn70);
    }

    public void backwardn60(View view) {
    }

    public void number60(View view) {
    }
}
