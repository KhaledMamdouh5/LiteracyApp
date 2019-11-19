package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN30 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n30);
    }

    public void number30(View view) {
    }

    public void backwardn30(View view) {
    }

    public void forwardn30(View view) {
        OpenActivityN40();
    }
    public void OpenActivityN40(){
        Intent openactivityn40 = new Intent(this, ActivityN40.class);
        startActivity(openactivityn40);
    }
}
