package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivitySecondExercise extends AppCompatActivity implements AdapterSecondExercise.OnItemClickListener {
    RecyclerView recyclerView;
    AdapterSecondExercise adapterSecondExercise;
    ArrayList<ModelSecondExercise> modelSecondExercise;
    ImageView wordImage;
    TextView wordsLetters;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_exercise);
        wordImage = findViewById(R.id.WordImageSecondExercise);
        wordsLetters = findViewById(R.id.WordsLettersSecondExercise);
        recyclerView = findViewById(R.id.recycler_view);
        editText = findViewById(R.id.EditTextSeconddExercise);

        final Integer[] WordsImages = {R.drawable.tail, R.drawable.flowers, R.drawable.shadow, R.drawable.oil, R.drawable.pound,
                R.drawable.blueberry, R.drawable.seed, R.drawable.clouds, R.drawable.cloud, R.drawable.oats, R.drawable.church};
        final String[] WordsLetters = {"يـ - ـل - ذ", "هـ - ز - ر - ـو", "ـل - ظـ", "يـ - ـت - ز", "ـيـ - ـه - جـ - ـنـ", "تـ - ت - ـو",
                "ـذ - ر - ة - بـ", "ـيـ - م - غـ - ـو", "ـمـ - غـ - ـة - ـيـ", "ـا - فـ - شـ - ن - ـو", "ـنـ - ـسـ - ـيـ - ـة - كـ"};

        final List<String> newWordsLetters = new ArrayList<>();
        for (String i : WordsLetters) {
            newWordsLetters.add(i);
        }
        modelSecondExercise = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            ModelSecondExercise model = new ModelSecondExercise(WordsImages[i]);
            modelSecondExercise.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivitySecondExercise.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterSecondExercise = new AdapterSecondExercise(ActivitySecondExercise.this, modelSecondExercise);
        adapterSecondExercise.setOnitemclicklistener(ActivitySecondExercise.this);

        adapterSecondExercise.setOnitemclicklistener(new AdapterSecondExercise.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                wordImage.setImageResource(WordsImages[position]);
                wordsLetters.setText(WordsLetters[position]);
            }
        });
        recyclerView.setAdapter(adapterSecondExercise);

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, ActivitySecondExercise.class);
    }

    public void forward(View view) {
        OpenActivityThirdExercise();
    }

    public void OpenActivityThirdExercise() {
        Intent openactivitythirdexercies = new Intent(this, ActivityThirdExercise.class);
        startActivity(openactivitythirdexercies);
    }

    public void correcting(View view) {

    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }

    public void backward(View view) {
        OpenActivityFirstExercise();
    }

    public void OpenActivityFirstExercise() {
        Intent openactivityfirstexercise = new Intent(this, ActivityFirstExercise.class);
        startActivity(openactivityfirstexercise);
    }
}
