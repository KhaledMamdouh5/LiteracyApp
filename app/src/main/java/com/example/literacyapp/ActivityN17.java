package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n17);
    }

    public void number17(View view) {
    }

    public void backwardn17(View view) {
    }

    public void forwardn17(View view) {
        OpenActivityN18();
    }
    public void OpenActivityN18(){
        Intent openactivityn18 = new Intent(this,ActivityN18.class);
        startActivity(openactivityn18);
    }
}
