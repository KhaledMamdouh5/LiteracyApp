package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n13);
    }

    public void number13(View view) {
    }

    public void backwardn13(View view) {
    }

    public void forwardn13(View view) {
        OpenActivityN14();
    }
    public void OpenActivityN14(){
        Intent openactivityn14 = new Intent(this,ActivityN14.class);
        startActivity(openactivityn14);
    }
}
