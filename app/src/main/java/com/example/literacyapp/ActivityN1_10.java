package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class ActivityN1_10 extends AppCompatActivity {
    int[] numberImage;
    int index;
    ImageView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n1_10);
        number = findViewById(R.id.Number);
        numberImage = new int[]{R.drawable.number1, R.drawable.number2, R.drawable.number3, R.drawable.number4,
                R.drawable.number5, R.drawable.number6, R.drawable.number7, R.drawable.number8, R.drawable.number9,
                R.drawable.number10};


    }

    public void forward(View view) {
        if (index < 9) {
            index++;
        }
        else {
            OpenActivityN11_90();
        }
        number.setImageResource(numberImage[index]);
    }

    public void OpenActivityN11_90(){
        Intent openactivityn11_90 = new Intent(this, ActivityN11_90.class);
        startActivity(openactivityn11_90);
    }

    public void number(View view) {
    }

    public void cameran1(View view) {
        Intent opencameran1 = new Intent();
        opencameran1.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(opencameran1);
    }

    public void backwardn1(View view) {
        if (index > 0) {
            index--;
        }
        else {
            OpenActivityZero();
        }
        number.setImageResource(numberImage[index]);
    }

    public void OpenActivityZero() {
        Intent openactivityzero = new Intent(this,ActivityZero.class);
        startActivity(openactivityzero);
    }

    public void onBackPressed(){
        OpenActivityStarting();
    }

    public void OpenActivityStarting(){
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getBooleanExtra("id" , false)){
            index = 9;
            number.setImageResource(numberImage[index]);
        }
    }
}
