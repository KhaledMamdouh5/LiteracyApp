package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN70 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n70);
    }

    public void forwardn70(View view) {
        OpenActivityN80();
    }
    public void OpenActivityN80(){
        Intent openactivityn80 = new Intent(this, ActivityN80.class);
        startActivity(openactivityn80);
    }

    public void backwardn70(View view) {
    }

    public void number70(View view) {
    }
}
