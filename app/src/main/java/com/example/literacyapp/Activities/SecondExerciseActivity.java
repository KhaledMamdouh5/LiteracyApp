package com.example.literacyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.literacyapp.R;

public class SecondExerciseActivity extends AppCompatActivity{
    ImageView wordImage;
    TextView wordsLetters;
    EditText editText;
    int Position = 0;
    int[] image;
    int[] audio;
    String[] question;
    String[] answer;
    MediaPlayer correct;
    MediaPlayer wrong;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_exercise_activity);
        wordImage = findViewById(R.id.WordImageSecondExercise);
        wordsLetters = findViewById(R.id.WordsLettersSecondExercise);
        editText = findViewById(R.id.EditTextSecondExercise);

        image = new int[]{R.drawable.tail, R.drawable.flowers, R.drawable.cloud, R.drawable.shadow, R.drawable.oil, R.drawable.pound,
                R.drawable.blueberry, R.drawable.seed, R.drawable.clouds, R.drawable.oats, R.drawable.church};
        audio = new int[]{R.raw.tailaudio, R.raw.flowersaudio, R.raw.cloudaudio, R.raw.shadowaudio, R.raw.oilaudio, R.raw.poundaudio,
                R.raw.blueberryaudio, R.raw.seedaudio, R.raw.cloudsaudio, R.raw.oatsaudio, R.raw.churchaudio};
        question = new String[]{"يـ - ـل - ذ","هـ - ز - ر - ـو","ـمـ - غـ - ـة - ـيـ","ـل - ظـ","يـ - ـت - ز","ـيـ - ـه - جـ - ـنـ",
                "تـ - ت - ـو","ـذ - ر - ة - بـ","ـيـ - م - غـ - ـو","ـا - فـ - شـ - ن - ـو","ـنـ - ـسـ - ـيـ - ـة - كـ"};
        answer = new String[]{"ذيل","زهور","غيمة","ظل","زيت","جنيه","توت","بذرة","غيوم","شوفان","كنيسة"};
        correct = MediaPlayer.create(this, R.raw.correctanswer);
        wrong = MediaPlayer.create(this, R.raw.wronganswer);
    }

    public void OpenActivityThirdExercise() {
        Intent openactivitythirdexercies = new Intent(this, ThirdExerciseActivity.class);
        startActivity(openactivitythirdexercies);
    }

    public void correcting(View view) {
        if (editText.getText().toString().equals(answer[Position])) {
            correct.start();
            editText.setText("");
            Position++;
            if (Position == 11) {
                correct.start();
                OpenActivityThirdExercise();
            }
        } else {
            wrong.start();
        }
        wordImage.setImageResource(image[Position]);
        wordsLetters.setText(question[Position]);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }

    public void backward(View view) {
        OpenActivityFirstExercise();
    }

    public void OpenActivityFirstExercise() {
        Intent openactivityfirstexercise = new Intent(this, ActivityFirstExercise.class);
        startActivity(openactivityfirstexercise);
    }

    public void audio(View view) {
        mediaPlayer = MediaPlayer.create(this, audio[Position]);
        mediaPlayer.start();
    }
}