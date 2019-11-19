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

public class ActivityLetters extends AppCompatActivity implements AdapterLetters.OnItemClickListener {
    RecyclerView recyclerView;
    ArrayList<ModelLetters> modelLetters;
    AdapterLetters adapterLetters;
    TextView letterName;
    ImageView letterImage;
    TextView letterAtBegin;
    TextView letterAtMiddle;
    TextView letterAtEnd;
    TextView letter_1;
    TextView letter_2;
    TextView letter_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        letterName = findViewById(R.id.LetterName);
        letterAtBegin = findViewById(R.id.LetterAtBegin);
        letterAtMiddle = findViewById(R.id.LetterAtMiddle);
        letterAtEnd = findViewById(R.id.LetterAtEnd);
        letter_1 = findViewById(R.id.Letter1);
        letter_2 = findViewById(R.id.Letter2);
        letter_3 = findViewById(R.id.Letter3);
        letterImage = findViewById(R.id.LetterImage);
        recyclerView = findViewById(R.id.recycler_view);

        final Integer[] LettersImages = {R.drawable.thefirstletter, R.drawable.thesecondletter, R.drawable.thethirdletter,
                R.drawable.thefourthletter, R.drawable.thefifthletter, R.drawable.thesixthletter, R.drawable.theseventhletter,
                R.drawable.theeighthletter, R.drawable.theninthletter, R.drawable.thetenthletter, R.drawable.theeleventhletter,
                R.drawable.thetwelfthletter, R.drawable.thethirteenthletter, R.drawable.thefourteenthletter,
                R.drawable.thefifteenthletter, R.drawable.thesixteenthletter, R.drawable.theseventeenthletter,
                R.drawable.theeighteenthletter, R.drawable.thenineteenthletter, R.drawable.thetwentiethletter,
                R.drawable.thetwentyfirstletter, R.drawable.thetwentysecondletter, R.drawable.thetwentythirdletter,
                R.drawable.thetwentyfourthletter, R.drawable.thetwentyfifthletter, R.drawable.thetwentysixthletter,
                R.drawable.thetwentyseventhletter, R.drawable.thetwentyeighthletter};
        final String[] LettersNames = {"حرف الألف", "حرف الباء", "حرف التاء", "حرف الثاء", "حرف الجيم", "حرف الحاء", "حرف الخاء",
                "حرف الدال", "حرف الذال", "حرف الراء", "حرف الزاي", "حرف السين", "حرف الشين", "حرف الصاد", "حرف الضاد", "حرف الطاء",
                "حرف الظاء", "حرف العين", "حرف الغين", "حرف الفاء", "حرف القاف", "حرف الكاف", "حرف اللام", "حرف الميم", "حرف النون",
                "حرف الهاء", "حرف الواو", "حرف الياء"};
        final String [] LettersAtBegin = {"ا","بـ","تـ","ثـ","جـ","حـ","خـ","د","ذ","ر","ز","سـ","شـ","صـ","ضـ",
                "طـ","ظـ","عـ","غـ","فـ","قـ","كـ","لـ","مـ","نـ","هـ","و","يـ"};
        final String [] LettersAtMiddle = {"ـا","ـبـ","ـتـ","ـثـ","ـجـ","ـحـ","ـخـ","ـد","ـذ","ـر","ـز","ـسـ","ـشـ","ـصـ","ـضـ",
                "ـطـ","ـظـ","ـعـ","ـغـ", "ـفـ","ـقـ","ـكـ","ـلـ","ـمـ","ـنـ","ـهـ","ـو","ـيـ"};
        final String [] LettersAtEnd = {"ـا","ـب","ـت","ـث","ـج","ـح","ـخ","ـد","ـذ","ـر","ـز","ـس","ـش","ـص","ـض",
                "ـط","ـظ","ـع","ـغ", "ـف","ـق","ـك","ـل","ـم","ـن","ـه","ـو","ـي"};
        final String [] Letters_1 = {"أَ","بَ","تَ","ثَ","جَ","حَ","خَ","دَ","ذَ","رَ","زَ","سَ","شَ","صَ","ضَ",
                "طَ", "ظَ","عَ","غَ","فَ","قَ","كَ","لَ","مَ","نَ","هَ","وَ","يَ"};
        final String [] Letters_2 = {"أُ","بُ","تُ","ثُ","جُ","حُ","خُ","دُ","ذُ","رُ","زُ","سُ","شُ","صُ","ضُ",
                "طُ","ظُ","عُ","غُ","فُ","قُ","كُ","لُ","مُ","نُ","هُ","","يُ"};
        final String [] Letters_3 = {"إِ","بِ","تِ","ثِ","جِ","حِ","خِ","دِ","ذِ","رِ","زِ","سِ","شِ","صِ","ضِ",
                "طِ","ظِ","عِ","غِ","فِ","قِ","كِ","لِ","مِ","نِ","هِ","وِ",""};

        final List<String> newLettersNames = new ArrayList<>();
        for (String i : LettersNames) {
            newLettersNames.add(i);
        }
        final List<String> newLettersAtBegin = new ArrayList<>();
        for (String i : LettersAtBegin){
            newLettersAtBegin.add(i);
        }
        final List<String> newLettersAtMiddle = new ArrayList<>();
        for (String i : LettersAtMiddle){
            newLettersAtMiddle.add(i);
        }
        final List<String> newLettersAtEnd = new ArrayList<>();
        for (String i : LettersAtEnd){
            newLettersAtEnd.add(i);
        }
        final List<String> newLetters_1 = new ArrayList<>();
        for (String i : Letters_1){
            newLetters_1.add(i);
        }
        final List<String> newLetters_2 = new ArrayList<>();
        for (String i : Letters_2){
            newLetters_2.add(i);
        }
        final List<String> newLetters_3 = new ArrayList<>();
        for (String i : Letters_3){
            newLetters_3.add(i);
        }

        modelLetters = new ArrayList<>();
        for (int i = 0; i < LettersImages.length; i++) {
            ModelLetters model = new ModelLetters(LettersImages[i], LettersNames[i]);
            modelLetters.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityLetters.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterLetters = new AdapterLetters(ActivityLetters.this, modelLetters);
        adapterLetters.setOnitemclicklistener(ActivityLetters.this);

        adapterLetters.setOnitemclicklistener(new AdapterLetters.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                letterImage.setImageResource(LettersImages[position]);
                letterName.setText(newLettersNames.get(position));
                letterAtBegin.setText(newLettersAtBegin.get(position));
                letterAtMiddle.setText(newLettersAtMiddle.get(position));
                letterAtEnd.setText(newLettersAtEnd.get(position));
                letter_1.setText(newLetters_1.get(position));
                letter_2.setText(newLetters_2.get(position));
                letter_3.setText(newLetters_3.get(position));
            }
        });
        recyclerView.setAdapter(adapterLetters);
    }


    public void letterimage (View view) {
    }

    public void letteratend (View view) {
    }

    public void letteratmiddle (View view) {
    }

    public void letteratbegin(View view) {
    }

    public void letter3(View view) {
    }

    public void letter2(View view) {
    }

    public void letter1(View view) {
    }

    public void forward(View view) {
        OpenActivityFirstExercise();
    }
    public void OpenActivityFirstExercise(){
        Intent openactivityfirstexercies = new Intent(this, ActivityFirstExercise.class);
        startActivity(openactivityfirstexercies);
    }

    public void camera(View view) {
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, ActivityLetters.class);
    }

    public void onBackPressed(){
        OpenActivityStarting();
    }

    public void OpenActivityStarting(){
        Intent openactivitystarting = new Intent(this, ActivityStarting.class);
        startActivity(openactivitystarting);
    }
}