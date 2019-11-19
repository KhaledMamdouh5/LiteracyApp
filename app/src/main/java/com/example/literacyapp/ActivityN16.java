package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n16);
    }

    public void number16(View view) {
    }

    public void backwardn16(View view) {
    }

    public void forwardn16(View view) {
        OpenActivityN17();
    }
    public void OpenActivityN17(){
        Intent openactivityn17 = new Intent(this,ActivityN17.class);
        startActivity(openactivityn17);
    }
}
