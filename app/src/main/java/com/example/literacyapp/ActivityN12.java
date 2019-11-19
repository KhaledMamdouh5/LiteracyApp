package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n12);
    }

    public void number12(View view) {
    }

    public void backwardn12(View view) {
    }

    public void forwardn12(View view) {
        OpenActivityN13();
    }
    public void OpenActivityN13(){
        Intent openactivityn13= new Intent(this,ActivityN13.class);
        startActivity(openactivityn13);
    }
}
