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
import android.widget.Toast;

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

        final List<ModelFourthExercise> FirstOptionList = new ArrayList<>();
        FirstOptionList.add(new ModelFourthExercise("سكر", false));
        FirstOptionList.add(new ModelFourthExercise("حصان", true));
        FirstOptionList.add(new ModelFourthExercise("تلفاز", true));
        FirstOptionList.add(new ModelFourthExercise("شمس", false));
        FirstOptionList.add(new ModelFourthExercise("سيارة", false));
        FirstOptionList.add(new ModelFourthExercise("كرة", false));
        FirstOptionList.add(new ModelFourthExercise("مكتب", false));
        FirstOptionList.add(new ModelFourthExercise("نجوم", true));
        FirstOptionList.add(new ModelFourthExercise("خيار", false));
        FirstOptionList.add(new ModelFourthExercise("دولاب", false));
        FirstOptionList.add(new ModelFourthExercise("كرسي", false));
        FirstOptionList.add(new ModelFourthExercise("بطيخة", false));
        FirstOptionList.add(new ModelFourthExercise("فراولة", true));

        final List<ModelFourthExercise> SecondOptionList = new ArrayList<>();
        SecondOptionList.add(new ModelFourthExercise("تمر", true));
        SecondOptionList.add(new ModelFourthExercise("قمر", false));
        SecondOptionList.add(new ModelFourthExercise("نقود", false));
        SecondOptionList.add(new ModelFourthExercise("سحلية", false));
        SecondOptionList.add(new ModelFourthExercise("ليمون", true));
        SecondOptionList.add(new ModelFourthExercise("قلم", false));
        SecondOptionList.add(new ModelFourthExercise("ساعة", false));
        SecondOptionList.add(new ModelFourthExercise("حقيبة", false));
        SecondOptionList.add(new ModelFourthExercise("ثور", false));
        SecondOptionList.add(new ModelFourthExercise("مصباح", true));
        SecondOptionList.add(new ModelFourthExercise("صندوق", true));
        SecondOptionList.add(new ModelFourthExercise("بطة", false));
        SecondOptionList.add(new ModelFourthExercise("سرير", false));

        final List<ModelFourthExercise> ThirdOptionList = new ArrayList<>();
        ThirdOptionList.add(new ModelFourthExercise("دجاج", false));
        ThirdOptionList.add(new ModelFourthExercise("حمار", false));
        ThirdOptionList.add(new ModelFourthExercise("قفص", false));
        ThirdOptionList.add(new ModelFourthExercise("ضفدع", true));
        ThirdOptionList.add(new ModelFourthExercise("تفاح", false));
        ThirdOptionList.add(new ModelFourthExercise("كتاب", true));
        ThirdOptionList.add(new ModelFourthExercise("مربعات", false));
        ThirdOptionList.add(new ModelFourthExercise("هلال", true));
        ThirdOptionList.add(new ModelFourthExercise("سلحفاة", true));
        ThirdOptionList.add(new ModelFourthExercise("مروحة", false));
        ThirdOptionList.add(new ModelFourthExercise("شمام", false));
        ThirdOptionList.add(new ModelFourthExercise("ثعبان", false));
        ThirdOptionList.add(new ModelFourthExercise("موز", false));

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
                firstoption.setText(FirstOptionList.get(position).getTitle());
                secondoption.setText(SecondOptionList.get(position).getTitle());
                thirdoption.setText(ThirdOptionList.get(position).getTitle());
            }
        });
        recyclerView.setAdapter(adapterFourthExercise);

        firstoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ModelFourthExercise modelfourthExercise : FirstOptionList) {
                    if (modelfourthExercise.getTitle().equals(firstoption.getText().toString()))
                        if (modelfourthExercise.isStatus())
                            Toast.makeText(ActivityFourthExercise.this, "Correct", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(ActivityFourthExercise.this, "Incorrect😢!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        secondoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ModelFourthExercise modelfourthExercise : SecondOptionList) {
                    if (modelfourthExercise.getTitle().equals(secondoption.getText().toString()))
                        if (modelfourthExercise.isStatus())
                            Toast.makeText(ActivityFourthExercise.this, "Correct", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(ActivityFourthExercise.this, "Incorrect😢!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        thirdoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ModelFourthExercise modelfourthExercise : ThirdOptionList) {
                    if (modelfourthExercise.getTitle().equals(thirdoption.getText().toString()))
                        if (modelfourthExercise.isStatus())
                            Toast.makeText(ActivityFourthExercise.this, "Correct", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(ActivityFourthExercise.this, "Incorrect😢!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void backward(View view) {
        OpenActivityThirdExercise();
    }

    private void OpenActivityThirdExercise() {
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

    public void forward(View view) {
    }
}