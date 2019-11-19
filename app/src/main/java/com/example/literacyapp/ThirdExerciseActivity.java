package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThirdExerciseActivity extends AppCompatActivity implements AdapterThirdExercise.OnItemClickListener {
    RecyclerView recyclerView;
    AdapterThirdExercise adapterThirdExercise;
    ArrayList<ModelThirdExercise> modelThirdExercise;
    ImageView wordImage;
    TextView wordsLetters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_exercise);
        wordImage = findViewById(R.id.WordImageThirdExercise);
        wordsLetters = findViewById(R.id.WordsLettersThirdExercise);
        recyclerView = findViewById(R.id.recycler_view);

        final Integer[] WordsImages = {R.drawable.tail, R.drawable.flowers, R.drawable.shadow, R.drawable.oil, R.drawable.pound,
                R.drawable.blueberry, R.drawable.seed, R.drawable.clouds, R.drawable.cloud, R.drawable.oats, R.drawable.church};
        final String[] WordsLetters = {"يـ - ـل - ذ","هـ - ز - ر - ـو","ـل - ظـ","يـ - ـت - ز","ـيـ - ـه - جـ - ـنـ","تـ - ت - ـو",
                "ـذ - ر - ة - بـ","ـيـ - م - غـ - ـو","ـمـ - غـ - ـة - ـيـ","ـا - فـ - شـ - ن - ـو","ـنـ - ـسـ - ـيـ - ـة - كـ"};

        final List<String> newWordsLetters = new ArrayList<>();
        for (String i : WordsLetters) {
            newWordsLetters.add(i);
        }
        modelThirdExercise = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            ModelThirdExercise model = new ModelThirdExercise(WordsImages[i]);
            modelThirdExercise.add(model);

            LinearLayoutManager layoutManager = new LinearLayoutManager(ThirdExerciseActivity.this,
                    LinearLayoutManager.HORIZONTAL, true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapterThirdExercise = new AdapterThirdExercise(ThirdExerciseActivity.this, modelThirdExercise);
            adapterThirdExercise.setOnitemclicklistener(ThirdExerciseActivity.this);

            adapterThirdExercise.setOnitemclicklistener(new AdapterThirdExercise.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    wordImage.setImageResource(WordsImages[position]);
                    wordsLetters.setText(WordsLetters[position]);
                }
            });
            recyclerView.setAdapter(adapterThirdExercise);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, ThirdExerciseActivity.class);
    }

    public void forward(View view) {
        OpenFourthExerciseActivity();
    }
    public void OpenFourthExerciseActivity(){
        Intent openfourthexerciesactivity = new Intent(this, FourthExerciseActivity.class);
        startActivity(openfourthexerciesactivity);
    }

    public void correcting(View view) {
    }
}