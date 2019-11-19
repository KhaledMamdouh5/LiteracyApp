package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n19);
    }

    public void number19(View view) {
    }

    public void backwardn19(View view) {
    }

    public void forwardn19(View view) {
        OpenActivityN20();
    }
    public void OpenActivityN20(){
        Intent openactivityn20 = new Intent(this, ActivityN20.class);
        startActivity(openactivityn20);
    }
}
