package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityN11 extends AppCompatActivity {

    int[] numberImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n11);

        numberImage = new int[]{R.drawable.number11, R.drawable.number12, R.drawable.number13, R.drawable.number14,
                R.drawable.number15, R.drawable.number16, R.drawable.number17, R.drawable.number18, R.drawable.number19,
                R.drawable.number20, R.drawable.number30, R.drawable.number40, R.drawable.number50, R.drawable.number60,
                R.drawable.number70, R.drawable.number80, R.drawable.number90};
    }

    public void number11(View view) {
    }

    public void backwardn11(View view) {
    }

    public void forwardn11(View view) {
        OpenActivityN12();
    }
    public void OpenActivityN12(){
        Intent openactivityn12 = new Intent(this,ActivityN12.class);
        startActivity(openactivityn12);
    }
}
