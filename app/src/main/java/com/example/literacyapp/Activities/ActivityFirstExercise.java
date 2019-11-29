package com.example.literacyapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.literacyapp.Adapters.FirstExerciseAdapter;
import com.example.literacyapp.Models.FirstExerciseModel;
import com.example.literacyapp.R;
import com.example.literacyapp.UploadDialog;

import java.util.ArrayList;
import java.util.List;

public class ActivityFirstExercise extends AppCompatActivity implements FirstExerciseAdapter.OnItemClickListener {
    private static final int Camera_Request_Code = 1;
    public static Bitmap bitmap;
    RecyclerView recyclerView;
    ArrayList<FirstExerciseModel> firstExerciseModel;
    FirstExerciseAdapter firstExerciseAdapter;
    TextView text_view;
    ImageView wordImage;
    String [] Words;
    static public String index;
    // int[] wordAudio;
    int Position = 0;
    //  MediaPlayer wordaudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_exercise_activity);
        text_view = findViewById(R.id.WordFirstExercise);
        wordImage = findViewById(R.id.WordImageFirstExercise);
        recyclerView = findViewById(R.id.recycler_view);

        final Integer[] WordsImages = {R.drawable.lion, R.drawable.ear, R.drawable.sea, R.drawable.tower, R.drawable.clothes,
                R.drawable.camel, R.drawable.dough, R.drawable.street, R.drawable.scissors, R.drawable.sheep, R.drawable.whale,
                R.drawable.milk};
        Words = new String[]{"أَسَد", "أُذُن", "بَحْر", "بُرْج", "ثِيَاب", "جَمَل", "عَجِين", "شَارِع", "مِقَص", "خَرُوف", "حُوت", "حَلِيب"};
        //  wordAudio = new int[]{R.raw.lionaudio, R.raw., R.raw., R.raw., R.raw., R.raw.camelaudio, R.raw., R.raw., R.raw.scissorsaudio,
        //        R.raw., R.raw., R.raw.};

        final List<String> newWords = new ArrayList<>();
        for (String i : Words) {
            newWords.add(i);
        }

        firstExerciseModel = new ArrayList<>();
        for (int i = 0; i < WordsImages.length; i++) {
            FirstExerciseModel model = new FirstExerciseModel(WordsImages[i], Words[i]);
            firstExerciseModel.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityFirstExercise.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        firstExerciseAdapter = new FirstExerciseAdapter(ActivityFirstExercise.this, firstExerciseModel);
        firstExerciseAdapter.setOnitemclicklistener(ActivityFirstExercise.this);

        firstExerciseAdapter.setOnitemclicklistener(new FirstExerciseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Position = position;
                wordImage.setImageResource(WordsImages[position]);
                text_view.setText(newWords.get(position));
            }
        });
        //wordaudio = MediaPlayer.create(this, wordAudio[Position]);
        recyclerView.setAdapter(firstExerciseAdapter);
    }

    public void word_audio(View view) {
        //  wordaudio = MediaPlayer.create(this, wordAudio[Position]);
        // wordaudio.start();
    }

    public void camera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Camera_Request_Code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap = (Bitmap) data.getExtras().get("data");
        openDialog();
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, ActivityFirstExercise.class);
    }

    public void forward(View view) {
        OpenActivitySecondExercise();
    }

    public void OpenActivitySecondExercise() {
        Intent openactivitysecondexercies = new Intent(this, SecondExerciseActivity.class);
        startActivity(openactivitysecondexercies);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
    }

    public void openDialog() {
        index = Words [Position];
        UploadDialog uploadDialog = new UploadDialog();
        uploadDialog.show(getSupportFragmentManager(), "upload dialog");
    }
}
