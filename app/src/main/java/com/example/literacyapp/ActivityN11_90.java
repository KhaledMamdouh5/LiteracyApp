package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityN11_90 extends AppCompatActivity {
    int[] numberImage;
    int index;
    ImageView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n11_90);
        number = findViewById(R.id.Number);
        numberImage = new int[]{R.drawable.number11, R.drawable.number12, R.drawable.number13, R.drawable.number14,
                R.drawable.number15, R.drawable.number16, R.drawable.number17, R.drawable.number18, R.drawable.number19,
                R.drawable.number20, R.drawable.number30, R.drawable.number40, R.drawable.number50, R.drawable.number60,
                R.drawable.number70, R.drawable.number80, R.drawable.number90};
    }

    public void number(View view) {
    }

    public void backward(View view) {
        if (index > 0) {
            index--;
        }
        else {
            OpenActivityN1_10();
        }
        number.setImageResource(numberImage[index]);
    }

    public void OpenActivityN1_10() {
       Intent openactivityn1_10 = new Intent(this,ActivityN1_10.class);
       startActivity(openactivityn1_10);
    }

    public void forwardn(View view) {
        if (index < 16) {
            index++;
        }
        number.setImageResource(numberImage[index]);
    }

    public void onBackPressed(){
        OpenActivityStarting();
    }

    public void OpenActivityStarting(){
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }
}
