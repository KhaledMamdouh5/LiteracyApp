package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN20 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n20);
    }

    public void number20(View view) {
    }

    public void backwardn20(View view) {
    }

    public void forwardn20(View view) {
        OpenActivityN30();
    }
    public void OpenActivityN30(){
        Intent openactivityn30 = new Intent(this, ActivityN30.class);
        startActivity(openactivityn30);
    }
}
