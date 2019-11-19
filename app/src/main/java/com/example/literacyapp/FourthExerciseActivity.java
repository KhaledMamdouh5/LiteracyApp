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

public class FourthExerciseActivity extends AppCompatActivity implements AdapterFourthExercise.OnItemClickListener {
    RecyclerView recyclerView;
    AdapterFourthExercise adapterFourthExercise;
    ArrayList<ModelFourthExercise> modelFourthExercise;
    ImageView wordImage;
    TextView wordsLetters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_exercise);
        wordImage = findViewById(R.id.WordImageFourthExercise);
        wordsLetters = findViewById(R.id.WordsLettersForthExercise);
        recyclerView = findViewById(R.id.recycler_view);

        final Integer[] WordsImages = {R.drawable.garlic, R.drawable.arm, R.drawable.sail, R.drawable.toy, R.drawable.mountains,
                R.drawable.beans, R.drawable.juice, R.drawable.bread, R.drawable.rubbish, R.drawable.bones, R.drawable.present};
        final String[] WordsLetters = {"ـو - م - ثـ","ع - ا - ر - ذ","شـ - ا - ـر - ع","ـعـ - ـبـ - لـ - ـة","ـبـ - ـا - ل - جـ",
                "ل - فـ - ـو", "ـيـ - عـ - ـر - ـصـ","فـ - ر - غـ - ـيـ","مـ - ـا - قـ - ـة - ـمـ","ـم - عـ - ـظـ","ـد - هـ - ـة - يـ"};

        final List<String> newWordsLetters = new ArrayList<>();
        for (String i : WordsLetters) {
            newWordsLetters.add(i);
        }
        modelFourthExercise = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            ModelFourthExercise model = new ModelFourthExercise(WordsImages[i]);
            modelFourthExercise.add(model);

            LinearLayoutManager layoutManager = new LinearLayoutManager(FourthExerciseActivity.this,
                    LinearLayoutManager.HORIZONTAL, true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapterFourthExercise = new AdapterFourthExercise(FourthExerciseActivity.this, modelFourthExercise);
            adapterFourthExercise.setOnitemclicklistener(FourthExerciseActivity.this);

            adapterFourthExercise.setOnitemclicklistener(new AdapterFourthExercise.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    wordImage.setImageResource(WordsImages[position]);
                    wordsLetters.setText(WordsLetters[position]);
                }
            });
            recyclerView.setAdapter(adapterFourthExercise);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, FourthExerciseActivity.class);
    }

    public void forward(View view) {
    }

    public void correcting(View view) {
    }
}