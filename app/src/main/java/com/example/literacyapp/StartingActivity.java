package com.example.literacyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class StartingActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu mentormenu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mentorlist,mentormenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mentor_list:
                OpenActivityMentor();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }

    public void openletters(View view) {
        OpenMainActivity();
    }
    public void OpenMainActivity(){
        Intent openmainactivity = new Intent(this, LettersActivity.class);
        startActivity(openmainactivity);
    }
    public void opennumbers(View view) {
        OpenActivityZero();
    }
    public void OpenActivityZero(){
        Intent openactivityzero = new Intent(this, ActivityZero.class);
        startActivity(openactivityzero);
    }
    public void OpenActivityMentor(){
        Intent openactivitynmentor = new Intent(this, ActivityMentor.class);
        startActivity(openactivitynmentor);
    }
}
