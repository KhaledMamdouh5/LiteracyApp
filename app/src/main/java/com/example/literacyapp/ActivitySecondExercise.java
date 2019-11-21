package com.example.literacyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivitySecondExercise extends AppCompatActivity implements AdapterSecondExercise.OnItemClickListener {
    RecyclerView recyclerView;
    AdapterSecondExercise adapterSecondExercise;
    ArrayList<ModelSecondExercise> modelSecondExercise;
    ImageView wordImage;
    TextView wordsLetters;
    EditText editText;
    int Position = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_exercise);
        wordImage = findViewById(R.id.WordImageSecondExercise);
        wordsLetters = findViewById(R.id.WordsLettersSecondExercise);
        recyclerView = findViewById(R.id.recycler_view);
        editText = findViewById(R.id.EditTextSecondExercise);

        modelSecondExercise = new ArrayList<>();
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.tail , "يـ - ـل - ذ"  , "ذيل"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.flowers , "هـ - ز - ر - ـو"  ,"زهور"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.shadow , "ـل - ظـ"  ,"ظل"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.oil , "يـ - ـت - ز"  ,"زيت"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.pound , "ـيـ - ـه - جـ - ـنـ"  ,"جنيه"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.blueberry , "تـ - ت - ـو"  ,"توت"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.seed , "ـذ - ر - ة - بـ"  ,"بذرة"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.clouds , "ـيـ - م - غـ - ـو"  ,"غيوم"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.cloud , "ـمـ - غـ - ـة - ـيـ"  ,"غيمة"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.oats , "ـا - فـ - شـ - ن - ـو"  ,"شوفان"));
        modelSecondExercise.add(new ModelSecondExercise(R.drawable.church , "ـنـ - ـسـ - ـيـ - ـة - كـ"  ,"كنيسة"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivitySecondExercise.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterSecondExercise = new AdapterSecondExercise(ActivitySecondExercise.this, modelSecondExercise);
        adapterSecondExercise.setOnitemclicklistener(ActivitySecondExercise.this);

        adapterSecondExercise.setOnitemclicklistener(new AdapterSecondExercise.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                editText.setText("");
                Position = position;
                wordImage.setImageResource(modelSecondExercise.get(position).getImage());
                wordsLetters.setText(modelSecondExercise.get(position).getQuestion());
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
        if (editText.getText().toString().equals(modelSecondExercise.get(Position).getAnswer())) {
            Toast.makeText(getApplicationContext() , "إجابة صحيحة" , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext() , "إجابة خاطئة" , Toast.LENGTH_SHORT).show();
        }
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