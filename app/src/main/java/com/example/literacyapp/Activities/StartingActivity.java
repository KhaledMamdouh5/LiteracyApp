package com.example.literacyapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.literacyapp.R;
import com.google.firebase.auth.FirebaseAuth;

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
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LogInActivity.class));
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_activity);
    }

    public void openletters(View view) {
        OpenActivityLetters();
    }
    public void OpenActivityLetters(){
        Intent openactivityletters = new Intent(this, ActivityLetters.class);
        startActivity(openactivityletters);
    }
    public void opennumbers(View view) {
        OpenActivityZero();
    }
    public void OpenActivityZero(){
        Intent openactivityzero = new Intent(this, ZeroActivity.class);
        startActivity(openactivityzero);
    }
    public void OpenActivityMentor(){
        Intent openactivitynmentor = new Intent(this, ActivityMentor.class);
        startActivity(openactivitynmentor);
    }

    public void onBackPressed() {
        Intent closeApp = new Intent(Intent.ACTION_MAIN);
        closeApp.addCategory(Intent.CATEGORY_HOME);
        closeApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(closeApp);
    }
}
