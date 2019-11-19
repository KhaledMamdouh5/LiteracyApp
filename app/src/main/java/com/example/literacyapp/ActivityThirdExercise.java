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

public class ActivityThirdExercise extends AppCompatActivity implements AdapterThirdExercise.OnItemClickListener {
    RecyclerView recyclerView;
    AdapterThirdExercise adapterThirdExercise;
    ArrayList<ModelThirdExercise> modelThirdExercise;
    ImageView wordImage;
    TextView wordsLetters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_exercise);
        wordImage = findViewById(R.id.WordImageFourthExercise);
        wordsLetters = findViewById(R.id.WordsLettersForthExercise);
        recyclerView = findViewById(R.id.recycler_view);

        final Integer[] WordsImages = {R.drawable.garlic, R.drawable.arm, R.drawable.sail, R.drawable.toy, R.drawable.mountains,
                R.drawable.beans, R.drawable.juice, R.drawable.bread, R.drawable.rubbish, R.drawable.bones, R.drawable.present};
        final String[] WordsLetters = {"ـو - م - ثـ","ع - ا - ر - ذ","شـ - ا - ـر - ع","ـعـ - ـبـ - لـ - ـة","ـبـ - ـا - ل - جـ",
                "ل - فـ - ـو", "ـيـ - عـ - ـر - ـصـ","ـف - ر - غـ - ـيـ","مـ - ـا - قـ - ـة - ـمـ","ـم - عـ - ـظـ","ـد - هـ - ـة - يـ"};

        final List<String> newWordsLetters = new ArrayList<>();
        for (String i : WordsLetters) {
            newWordsLetters.add(i);
        }
        modelThirdExercise = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            ModelThirdExercise model = new ModelThirdExercise(WordsImages[i]);
            modelThirdExercise.add(model);

            LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityThirdExercise.this,
                    LinearLayoutManager.HORIZONTAL, true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapterThirdExercise = new AdapterThirdExercise(ActivityThirdExercise.this, modelThirdExercise);
            adapterThirdExercise.setOnitemclicklistener(ActivityThirdExercise.this);

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
        Intent detailIntent = new Intent(this, ActivityThirdExercise.class);
    }

    public void forward(View view) {
        OpenActivityFourthExercise();
    }

    public void OpenActivityFourthExercise() {
        Intent openactivityfourthexercise = new Intent(this, ActivityFourthExercise.class);
        startActivity(openactivityfourthexercise);
    }

    public void correcting(View view) {
    }

    public void onBackPressed(){
        OpenActivityStarting();
    }

    public void OpenActivityStarting(){
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }

    public void backward(View view) {
        OpenActivitySecondExercise();
    }

    public void OpenActivitySecondExercise(){
        Intent openactivitysecondexercise = new Intent(this, ActivitySecondExercise.class);
        startActivity(openactivitysecondexercise);
    }
}