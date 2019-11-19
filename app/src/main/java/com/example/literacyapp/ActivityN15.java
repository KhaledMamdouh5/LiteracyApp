package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n15);
    }

    public void number15(View view) {
    }

    public void backwardn15(View view) {
    }

    public void forwardn15(View view) {
        OpenActivityN16();
    }
    public void OpenActivityN16(){
        Intent openactivityn16 = new Intent(this,ActivityN16.class);
        startActivity(openactivityn16);
    }
}
