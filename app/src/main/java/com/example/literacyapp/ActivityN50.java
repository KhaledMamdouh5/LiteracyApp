package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN50 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n50);
    }

    public void forwardn50(View view) {
        OpenActivityN60();
    }
    public void OpenActivityN60(){
        Intent openactivityn60 = new Intent(this, ActivityN60.class);
        startActivity(openactivityn60);
    }

    public void backwardn50(View view) {
    }

    public void number50(View view) {
    }
}
