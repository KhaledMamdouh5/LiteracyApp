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
        setContentView(R.layout.activity_n1);
        number = findViewById(R.id.Number);
        numberImage = new int[]{R.drawable.number1, R.drawable.number2, R.drawable.number3, R.drawable.number4,
                R.drawable.number5, R.drawable.number6, R.drawable.number7, R.drawable.number8, R.drawable.number9,
                R.drawable.number10};
    }

    public void forwardn1(View view) {
        index++;
        number.setImageResource(numberImage[index]);
    }

    public void number1(View view) {
    }

    public void cameran1(View view) {
        Intent opencameran1 = new Intent();
        opencameran1.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(opencameran1);
    }

    public void backwardn1(View view) {
        OpenActivityZero();
    }

    public void OpenActivityZero() {
        Intent openactivityzero = new Intent(this, ActivityZero.class);
        startActivity(openactivityzero);
    }
}
