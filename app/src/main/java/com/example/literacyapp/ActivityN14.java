package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n14);
    }

    public void number14(View view) {
    }

    public void backwardn14(View view) {
    }

    public void forwardn14(View view) {
        OpenActivityN15();
    }
    public void OpenActivityN15(){
        Intent openactivityn15 = new Intent(this,ActivityN15.class);
        startActivity(openactivityn15);
    }
}
