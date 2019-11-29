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

public class ThirdExerciseActivity extends AppCompatActivity{

    ImageView wordImage;
    TextView wordsLetters;
    EditText editText;
    int Position = 0;
    int[] image;
    String[] question;
    String[] answer;
    MediaPlayer correct;
    MediaPlayer wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_exercise_activity);
        wordImage = findViewById(R.id.WordImageThirdExercise);
        wordsLetters = findViewById(R.id.WordsLettersThirdExercise);
        editText = findViewById(R.id.EditTextThirdExercise);
        correct = MediaPlayer.create(this, R.raw.correctanswer);
        wrong = MediaPlayer.create(this, R.raw.wronganswer);

        image = new int[]{R.drawable.garlic, R.drawable.arm, R.drawable.sail, R.drawable.toy, R.drawable.mountains, R.drawable.beans,
                R.drawable.juice, R.drawable.bread, R.drawable.rubbish, R.drawable.bones, R.drawable.present};
        question = new String[]{"ـو - م - ثـ","ع - ا - ر - ذ","شـ - ا - ـر - ع","ـعـ - ـبـ - لـ - ـة","ـبـ - ـا - ل - جـ","ل - فـ - ـو",
                "ـيـ - عـ - ـر - ـصـ","ـف - ر - غـ - ـيـ","مـ - ـا - قـ - ـة - ـمـ","ـم - عـ - ـظـ","ـد - هـ - ـة - يـ"};
        answer = new String[]{"ثوم","ذراع","شراع","لعبة","جبال","فول","عصير","رغيف","قمامة","عظم","هدية"};
    }


    public void correcting(View view) {
        if (editText.getText().toString().equals(answer[Position])) {
            correct.start();
            editText.setText("");
            Position++;
            if (Position == 11) {
                correct.start();
                OpenActivityFourthExercise();
            }
        } else {
            wrong.start();
        }
        wordImage.setImageResource(image[Position]);
        wordsLetters.setText(question[Position]);
    }

    public void OpenActivityFourthExercise() {
        Intent openactivityfourthexercise = new Intent(this, ActivityFourthExercise.class);
        startActivity(openactivityfourthexercise);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }

    public void backward(View view) {
        OpenActivitySecondExercise();
    }

    public void OpenActivitySecondExercise() {
        Intent openactivitysecondexercise = new Intent(this, SecondExerciseActivity.class);
        startActivity(openactivitysecondexercise);
    }
}