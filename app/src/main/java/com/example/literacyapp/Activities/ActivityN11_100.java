package com.example.literacyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.literacyapp.R;

public class ActivityN11_100 extends AppCompatActivity {
    int[] numberImage;
    int[] numberaudio;
    int index;
    MediaPlayer mediaPlayer;
    ImageView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n11_100_activity);
        number = findViewById(R.id.Number);
        numberImage = new int[]{R.drawable.number11, R.drawable.number12, R.drawable.number13, R.drawable.number14,
                R.drawable.number15, R.drawable.number16, R.drawable.number17, R.drawable.number18, R.drawable.number19,
                R.drawable.number20, R.drawable.number30, R.drawable.number40, R.drawable.number50, R.drawable.number60,
                R.drawable.number70, R.drawable.number80, R.drawable.number90, R.drawable.number100};
        numberaudio = new int[]{R.raw.eleven, R.raw.twelve, R.raw.thirteen, R.raw.fourteen, R.raw.fifteen, R.raw.sixteen, R.raw.seventeen,
                R.raw.eighteen, R.raw.nineteen, R.raw.twenty, R.raw.thirty, R.raw.fourty, R.raw.fifty, R.raw.sixty, R.raw.seventy,
                R.raw.eighty, R.raw.ninety, R.raw.onehundred};
    }

    public void number(View view) {
        mediaPlayer = MediaPlayer.create(this, numberaudio[index]);
        mediaPlayer.start();
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
       openactivityn1_10.putExtra("id",true);
       startActivity(openactivityn1_10);
    }

    public void forwardn(View view) {
        if (index < 17) {
            index++;
        }
        number.setImageResource(numberImage[index]);
    }

    public void onBackPressed(){
        OpenActivityStarting();
    }

    public void OpenActivityStarting(){
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }
}
