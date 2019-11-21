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
import java.util.List;

public class ActivityThirdExercise extends AppCompatActivity implements AdapterThirdExercise.OnItemClickListener {
    RecyclerView recyclerView;
    AdapterThirdExercise adapterThirdExercise;
    ArrayList<ModelThirdExercise> modelThirdExercise;
    ImageView wordImage;
    TextView wordsLetters;
    EditText editText;
    int Position = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_exercise);
        wordImage = findViewById(R.id.WordImageThirdExercise);
        wordsLetters = findViewById(R.id.WordsLettersThirdExercise);
        recyclerView = findViewById(R.id.recycler_view);
        editText = findViewById(R.id.EditTextThirdExercise);

        modelThirdExercise = new ArrayList<>();
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.garlic , "ـو - م - ثـ"  , "ثوم"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.arm , "ع - ا - ر - ذ"  , "ذراع"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.sail , "شـ - ا - ـر - ع"  , "شراع"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.toy , "ـعـ - ـبـ - لـ - ـة"  , "لعبة"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.mountains , "ـبـ - ـا - ل - جـ"  , "جبال"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.beans , "ل - فـ - ـو"  , "فول"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.juice , "ـيـ - عـ - ـر - ـصـ"  , "عصير"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.bread , "ـف - ر - غـ - ـيـ"  , "رغيف"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.rubbish , "مـ - ـا - قـ - ـة - ـمـ"  , "قمامة"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.bones , "ـم - عـ - ـظـ"  , "عظم"));
        modelThirdExercise.add(new ModelThirdExercise(R.drawable.present , "ـد - هـ - ـة - يـ"  , "هدية"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityThirdExercise.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterThirdExercise = new AdapterThirdExercise(ActivityThirdExercise.this, modelThirdExercise);
        adapterThirdExercise.setOnitemclicklistener(ActivityThirdExercise.this);

        adapterThirdExercise.setOnitemclicklistener(new AdapterThirdExercise.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                editText.setText("");
                Position = position;
                wordImage.setImageResource(modelThirdExercise.get(position).getImage());
                wordsLetters.setText(modelThirdExercise.get(position).getQuestion());
            }
        });
        recyclerView.setAdapter(adapterThirdExercise);

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
        if (editText.getText().toString().equals(modelThirdExercise.get(Position).getAnswer())) {
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
        OpenActivitySecondExercise();
    }

    public void OpenActivitySecondExercise() {
        Intent openactivitysecondexercise = new Intent(this, ActivitySecondExercise.class);
        startActivity(openactivitysecondexercise);
    }
}