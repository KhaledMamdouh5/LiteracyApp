package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN18 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n18);
    }

    public void number18(View view) {
    }

    public void backwardn18(View view) {
    }

    public void forwardn18(View view) {
        OpenActivityN19();
    }
    public void OpenActivityN19(){
        Intent openactivityn19 = new Intent(this,ActivityN19.class);
        startActivity(openactivityn19);
    }
}
