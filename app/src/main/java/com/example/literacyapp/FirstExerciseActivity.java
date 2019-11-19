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

public class FirstExerciseActivity extends AppCompatActivity implements AdapterFirstExercise.OnItemClickListener{
    RecyclerView recyclerView;
    ArrayList<ModelFirstExercise> modelFirstExercise;
    AdapterFirstExercise adapterFirstExercise;
    TextView text_view;
    ImageView wordImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_exercise);
        text_view = findViewById(R.id.WordFirstExercise);
        wordImage = findViewById(R.id.WordImageFirstExercise);
        recyclerView =  findViewById(R.id.recycler_view);

        final Integer[] WordsImages = {R.drawable.lion, R.drawable.ear, R.drawable.sea, R.drawable.tower, R.drawable.clothes,
                R.drawable.camel, R.drawable.dough, R.drawable.street, R.drawable.scissors, R.drawable.sheep, R.drawable.whale,
                R.drawable.milk};
        final String[] Words = {"أَسَد","أُذُن","بَحْر","بُرْج","ثِيَاب","جَمَل","عَجِين","شَارِع","مِقَص","خَرُوف","حُوت","حَلِيب"};

        final List<String> newWords = new ArrayList<>();
        for (String i : Words) {
            newWords.add(i);
        }

        modelFirstExercise = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            ModelFirstExercise model = new ModelFirstExercise(WordsImages[i], Words[i]);
            modelFirstExercise.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(FirstExerciseActivity.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterFirstExercise = new AdapterFirstExercise(FirstExerciseActivity.this, modelFirstExercise);
        adapterFirstExercise.setOnitemclicklistener(FirstExerciseActivity.this);

        adapterFirstExercise.setOnitemclicklistener(new AdapterFirstExercise.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                wordImage.setImageResource(WordsImages[position]);
                text_view.setText(newWords.get(position));
            }
        });
        recyclerView.setAdapter(adapterFirstExercise);
    }

    public void camera(View view) {
    }

    public void wordimage(View view) {
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, FirstExerciseActivity.class);
    }

    public void forward(View view) {
        OpenThirdExerciseActivity();
    }
    public void OpenThirdExerciseActivity(){
        Intent openthirdexerciesactivity = new Intent(this, ThirdExerciseActivity.class);
        startActivity(openthirdexerciesactivity);
    }
}
