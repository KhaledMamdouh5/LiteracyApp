package com.example.literacyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.literacyapp.R;

public class FifthExerciseActivity extends AppCompatActivity {
    ImageView wordImage;
    Button firstoption;
    Button secondoption;
    Button thirdoption;
    MediaPlayer correct;
    MediaPlayer wrong;
    int [] WordsImages;
    boolean[] option_1;
    boolean[] option_2;
    boolean[] option_3;
    String[] option1;
    String[] option2;
    String[] option3;
    int Position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_exercise_activity);
        wordImage = findViewById(R.id.WordImage);
        firstoption = findViewById(R.id.Option1);
        secondoption = findViewById(R.id.Option2);
        thirdoption = findViewById(R.id.Option3);
        correct = MediaPlayer.create(this, R.raw.correctanswer);
        wrong = MediaPlayer.create(this, R.raw.wronganswer);
        WordsImages = new int[]{R.drawable.dates, R.drawable.horse, R.drawable.television, R.drawable.frog, R.drawable.lemon,
                R.drawable.book, R.drawable.stars, R.drawable.crescent, R.drawable.turtle, R.drawable.bulb, R.drawable.box,
                R.drawable.snake, R.drawable.strawberry};
        option_1 = new boolean[]{false, true, true, false, false, false, true, false, false, false, false, false, true};
        option_2 = new boolean[]{true, false, false, false, true, false, false, false, false, true, true, false, false};
        option_3 = new boolean[]{false, false, false, true, false, true, false, true, true, false, false, true, false};
        option1 = new String[]{"سكر", "حصان", "تلفاز", "شمس", "سيارة", "كرة", "نجوم", "مكتب", "خيار", "دولاب", "كرسي", "بطيخة", "فراولة"};
        option2 = new String[]{"تمر", "قمر", "نقود", "سحلية", "ليمون", "قلم", "ساعة", "حقيبة", "ثور", "مصباح", "صندوق", "بطة", "سرير"};
        option3 = new String[]{"دجاج", "حمار", "قفص", "ضفدع", "تفاح", "كتاب", "مربعات", "هلال", "سلحفاة", "مروحة", "شمام", "ثعبان", "موز"};
    }

    public void backward(View view) {
        OpenActivityThirdExercise();
    }

    private void OpenActivityThirdExercise() {
        Intent openactivitythirdexercise = new Intent(this, ThirdExerciseActivity.class);
        startActivity(openactivitythirdexercise);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }

    public void forward(View view) {
    }

    public void Option3(View view) {
        if (option_3[Position]) {
            correct.start();
            Position++;
        } else {
            wrong.start();
        }
        firstoption.setText(option1[Position]);
        secondoption.setText(option2[Position]);
        thirdoption.setText(option3[Position]);
        wordImage.setImageResource(WordsImages[Position]);
    }

    public void Option2(View view) {
        if (option_2[Position]) {
            correct.start();
            Position++;
        } else {
            wrong.start();
        }
        firstoption.setText(option1[Position]);
        secondoption.setText(option2[Position]);
        thirdoption.setText(option3[Position]);
        wordImage.setImageResource(WordsImages[Position]);
    }

    public void Option1(View view) {
        if (option_1[Position]) {
            correct.start();
            Position++;
        } else {
            wrong.start();
        }
        firstoption.setText(option1[Position]);
        secondoption.setText(option2[Position]);
        thirdoption.setText(option3[Position]);
        wordImage.setImageResource(WordsImages[Position]);
    }
}