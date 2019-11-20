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

public class ActivityFourthExercise extends AppCompatActivity implements AdapterFourthExercise.OnItemClickListener {
    RecyclerView recyclerView;
    ArrayList<ModelFourthExercise> modelFourthExercise;
    AdapterFourthExercise adapterFourthExercise;
    ImageView wordImage;
    TextView firstoption;
    TextView secondoption;
    TextView thirdoption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_exercise);
        recyclerView = findViewById(R.id.recycler_view);
        wordImage = findViewById(R.id.WordImage);
        firstoption = findViewById(R.id.Option1);
        secondoption = findViewById(R.id.Option2);
        thirdoption = findViewById(R.id.Option3);
        final Integer[] WordsImages = {R.drawable.dates, R.drawable.horse, R.drawable.television, R.drawable.frog, R.drawable.lemon,
                R.drawable.book, R.drawable.stars, R.drawable.crescent, R.drawable.turtle, R.drawable.bulb, R.drawable.box,
                R.drawable.snake, R.drawable.strawberry};
        final String [] FirstOption = {"نقود","حصان","تلفاز","","","","نجوم","","","","","","فراولة"};
        final String [] SecondOption = {"تمر","","","","ليمون","","","","","مصباح","صندوق","",""};
        final String [] ThirdOption = {"دجاج","","","ضفدع","","كتاب","","هلال","سلحفاة","","","ثعبان",""};

        final List<String> newFirstOption = new ArrayList<>();
        for (String i : FirstOption) {
            newFirstOption.add(i);
        }
        final List<String> newSecondOption = new ArrayList<>();
        for (String i : SecondOption){
            newSecondOption.add(i);
        }
        final List<String> newThirdOption = new ArrayList<>();
        for (String i : ThirdOption){
            newThirdOption.add(i);
        }

        modelFourthExercise = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            ModelFourthExercise model = new ModelFourthExercise(WordsImages[i]);
            modelFourthExercise.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityFourthExercise.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterFourthExercise = new AdapterFourthExercise(ActivityFourthExercise.this, modelFourthExercise);
        adapterFourthExercise.setOnitemclicklistener(ActivityFourthExercise.this);

        adapterFourthExercise.setOnitemclicklistener(new AdapterFourthExercise.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                wordImage.setImageResource(WordsImages[position]);
                firstoption.setText(newFirstOption.get(position));
                secondoption.setText(newSecondOption.get(position));
                thirdoption.setText(newThirdOption.get(position));
            }
        });
        recyclerView.setAdapter(adapterFourthExercise);
    }

    public void backward(View view) {
        OpenActivityThirdExercise();
    }

    private void OpenActivityThirdExercise(){
        Intent openactivitythirdexercise = new Intent(this, ActivityThirdExercise.class);
        startActivity(openactivitythirdexercise);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, ActivityFourthExercise.class);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }
}
