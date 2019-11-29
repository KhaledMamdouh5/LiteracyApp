package com.example.literacyapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.literacyapp.R;
import com.example.literacyapp.UploadDialog;

public class ActivityN1_10 extends AppCompatActivity {
    private static final int Camera_Request_Code = 1;
    public static Bitmap bitmap;
    int[] numberImage;
    MediaPlayer mediaPlayer;
    int i;
    ImageView number;
    int[] numberaudio;
    String [] numberName;
    static public String index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n1_10_activity);
        number = findViewById(R.id.Number);
        numberImage = new int[]{R.drawable.number1, R.drawable.number2, R.drawable.number3, R.drawable.number4,
                R.drawable.number5, R.drawable.number6, R.drawable.number7, R.drawable.number8, R.drawable.number9,
                R.drawable.number10};
        numberaudio = new int[]{R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five, R.raw.six, R.raw.seven, R.raw.eight,
                R.raw.nine, R.raw.ten};
        numberName = new String[]{"واحد","اثنان","ثلاثة","أربعة","خمسة","ستة","سبعة","ثمانية","تسعة","عشرة"};
        mediaPlayer = MediaPlayer.create(this, numberaudio[i]);

    }

    public void forward(View view) {
        if (i < 9) {
            i++;
        } else {
            OpenActivityN11_90();
        }
        number.setImageResource(numberImage[i]);
    }

    public void OpenActivityN11_90() {
        Intent openactivityn11_90 = new Intent(this, ActivityN11_100.class);
        startActivity(openactivityn11_90);
    }

    public void number(View view) {
        mediaPlayer = MediaPlayer.create(this, numberaudio[i]);
        mediaPlayer.start();
    }


    public void backwardn1(View view) {
        if (i > 0) {
            i--;
        } else {
            OpenActivityZero();
        }
        number.setImageResource(numberImage[i]);
    }

    public void OpenActivityZero() {
        Intent openactivityzero = new Intent(this, ZeroActivity.class);
        startActivity(openactivityzero);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getBooleanExtra("id", false)) {
            i = 9;
            number.setImageResource(numberImage[i]);
        }
    }

    public void camera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Camera_Request_Code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap = (Bitmap) data.getExtras().get("data");
        openDialog();
    }

    public void openDialog() {
        index = numberName[i];
        UploadDialog uploadDialog = new UploadDialog();
        uploadDialog.show(getSupportFragmentManager(), "upload dialog");
    }
}
