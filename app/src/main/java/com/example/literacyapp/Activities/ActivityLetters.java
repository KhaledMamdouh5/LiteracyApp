package com.example.literacyapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.literacyapp.Adapters.LettersAdapter;
import com.example.literacyapp.Models.LettersModel;
import com.example.literacyapp.R;
import com.example.literacyapp.UploadDialog;

import java.util.ArrayList;
import java.util.List;

public class ActivityLetters extends AppCompatActivity implements LettersAdapter.OnItemClickListener {
    private static final int Camera_Request_Code = 1;
    public static Bitmap bitmap;
    RecyclerView recyclerView;
    ArrayList<LettersModel> letterModels;
    LettersAdapter lettersAdapter;
    TextView letterName;
    ImageView letterImage;
    Button letterAtBegin;
    Button letterAtMiddle;
    Button letterAtEnd;
    Button letter_1;
    Button letter_2;
    Button letter_3;
    int[] lettterAudio;
    int[] letterAudio_1;
    int[] letterAudio_2;
    int[] letterAudio_3;
    MediaPlayer lettername;
    MediaPlayer letteraudioatbegin;
    MediaPlayer letteraudioatmiddle;
    MediaPlayer letteraudioatend;
    MediaPlayer letteraudio_1;
    MediaPlayer letteraudio_2;
    MediaPlayer letteraudio_3;
    int Position = 0;
    String[] LettersNames ;
    static public String index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letters_activity);
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
         LettersNames = new String[]{"حرف الألف", "حرف الباء", "حرف التاء", "حرف الثاء", "حرف الجيم", "حرف الحاء", "حرف الخاء",
                 "حرف الدال", "حرف الذال", "حرف الراء", "حرف الزاي", "حرف السين", "حرف الشين", "حرف الصاد", "حرف الضاد", "حرف الطاء",
                 "حرف الظاء", "حرف العين", "حرف الغين", "حرف الفاء", "حرف القاف", "حرف الكاف", "حرف اللام", "حرف الميم", "حرف النون",
                 "حرف الهاء", "حرف الواو", "حرف الياء"};
        final String[] LettersAtBegin = {"أ", "بـ", "تـ", "ثـ", "جـ", "حـ", "خـ", "د", "ذ", "ر", "ز", "سـ", "شـ", "صـ", "ضـ",
                "طـ", "ظـ", "عـ", "غـ", "فـ", "قـ", "كـ", "لـ", "مـ", "نـ", "هـ", "و", "يـ"};
        final String[] LettersAtMiddle = {"ـأ", "ـبـ", "ـتـ", "ـثـ", "ـجـ", "ـحـ", "ـخـ", "ـد", "ـذ", "ـر", "ـز", "ـسـ", "ـشـ", "ـصـ", "ـضـ",
                "ـطـ", "ـظـ", "ـعـ", "ـغـ", "ـفـ", "ـقـ", "ـكـ", "ـلـ", "ـمـ", "ـنـ", "ـهـ", "ـو", "ـيـ"};
        final String[] LettersAtEnd = {"ـأ", "ـب", "ـت", "ـث", "ـج", "ـح", "ـخ", "ـد", "ـذ", "ـر", "ـز", "ـس", "ـش", "ـص", "ـض",
                "ـط", "ـظ", "ـع", "ـغ", "ـف", "ـق", "ـك", "ـل", "ـم", "ـن", "ـه", "ـو", "ـي"};
        final String[] Letters_1 = {"أَ", "بَ", "تَ", "ثَ", "جَ", "حَ", "خَ", "دَ", "ذَ", "رَ", "زَ", "سَ", "شَ", "صَ", "ضَ",
                "طَ", "ظَ", "عَ", "غَ", "فَ", "قَ", "كَ", "لَ", "مَ", "نَ", "هَ", "وَ", "يَ"};
        final String[] Letters_2 = {"أُ", "بُ", "تُ", "ثُ", "جُ", "حُ", "خُ", "دُ", "ذُ", "رُ", "زُ", "سُ", "شُ", "صُ", "ضُ",
                "طُ", "ظُ", "عُ", "غُ", "فُ", "قُ", "كُ", "لُ", "مُ", "نُ", "هُ", "", "يُ"};
        final String[] Letters_3 = {"إِ", "بِ", "تِ", "ثِ", "جِ", "حِ", "خِ", "دِ", "ذِ", "رِ", "زِ", "سِ", "شِ", "صِ", "ضِ",
                "طِ", "ظِ", "عِ", "غِ", "فِ", "قِ", "كِ", "لِ", "مِ", "نِ", "هِ", "وِ", ""};
        lettterAudio = new int[]{R.raw.firstletter, R.raw.secondletter, R.raw.thirdletter, R.raw.fourthletter, R.raw.fifthletter,
                R.raw.sixthletter, R.raw.seventhletter, R.raw.eighthletter, R.raw.ninthletter, R.raw.tenthletter, R.raw.eleventhletter,
                R.raw.twelfthletter, R.raw.thirteenthletter, R.raw.fourteenthletter, R.raw.fifteenthletter, R.raw.sixteenthletter,
                R.raw.seventeenthletter, R.raw.eighteenthletter, R.raw.nineteenthletter, R.raw.twentiethletter, R.raw.twentyfirstletter,
                R.raw.twentysecondletter, R.raw.twentythirdletter, R.raw.twentyfourthletter, R.raw.twentyfifthletter,
                R.raw.twentysixthletter, R.raw.twentyseventhletter, R.raw.twentyeighthletter};
        letterAudio_1 = new int[]{R.raw.firstletter1, R.raw.secondletter1, R.raw.thirdletter1, R.raw.fourthletter1, R.raw.fifthletter1,
                R.raw.sixthletter1, R.raw.seventhletter1, R.raw.eighthletter1, R.raw.ninthletter1, R.raw.tenthletter1,
                R.raw.eleventhletter1, R.raw.twelvethletter1, R.raw.thirteenthletter1, R.raw.fourteenthletter1, R.raw.fifteenthletter1,
                R.raw.sixteenthletter1, R.raw.seventeenthletter1, R.raw.eighteenthletter1, R.raw.nineteenthletter1, R.raw.twentiethletter1,
                R.raw.twentyfirstletter1, R.raw.twentysecondletter1, R.raw.twentythirdletter1, R.raw.twentyfourthletter1,
                R.raw.twentyfifthletter1, R.raw.twentysixthletter1, R.raw.twentyseventhletter1, R.raw.twentyeighthletter1};
        letterAudio_2 = new int[]{R.raw.firstletter2, R.raw.secondletter2, R.raw.thirdletter2, R.raw.fourthletter2, R.raw.fifthletter2,
                R.raw.sixthletter2, R.raw.seventhletter2, R.raw.eighthletter2, R.raw.ninthletter2, R.raw.tenthletter2,
                R.raw.eleventhletter2, R.raw.twelvethletter2, R.raw.thirteenthletter2, R.raw.fourteenthletter2, R.raw.fifteenthletter2,
                R.raw.sixteenthletter2, R.raw.seventeenthletter2, R.raw.eighteenthletter2, R.raw.nineteenthletter2, R.raw.twentiethletter2,
                R.raw.twentyfirstletter2, R.raw.twentysecondletter2, R.raw.twentythirdletter2, R.raw.twentyfourthletter2,
                R.raw.twentyfifthletter2, R.raw.twentysixthletter2, R.raw.twentyeighthletter2};
        letterAudio_3 = new int[]{R.raw.firstletter3, R.raw.secondletter3, R.raw.thirdletter3, R.raw.fourthletter3, R.raw.fifthletter3,
                R.raw.sixthletter3, R.raw.seventhletter3, R.raw.eighthletter3, R.raw.ninthletter3, R.raw.tenthletter3,
                R.raw.eleventhletter3, R.raw.twelvethletter3, R.raw.thirteenthletter3, R.raw.fourteenthletter3, R.raw.fifteenthletter3,
                R.raw.sixteenthletter3, R.raw.seventeenthletter3, R.raw.eighteenthletter3, R.raw.nineteenthletter3, R.raw.twentiethletter3,
                R.raw.twentyfirstletter3, R.raw.twentysecondletter3, R.raw.twentythirdletter3, R.raw.twentyfourthletter3,
                R.raw.twentyfifthletter3, R.raw.twentysixthletter3, R.raw.twentyseventhletter3};

        final List<String> newLettersNames = new ArrayList<>();
        for (String i : LettersNames) {
            newLettersNames.add(i);
        }
        final List<String> newLettersAtBegin = new ArrayList<>();
        for (String i : LettersAtBegin) {
            newLettersAtBegin.add(i);
        }
        final List<String> newLettersAtMiddle = new ArrayList<>();
        for (String i : LettersAtMiddle) {
            newLettersAtMiddle.add(i);
        }
        final List<String> newLettersAtEnd = new ArrayList<>();
        for (String i : LettersAtEnd) {
            newLettersAtEnd.add(i);
        }
        final List<String> newLetters_1 = new ArrayList<>();
        for (String i : Letters_1) {
            newLetters_1.add(i);
        }
        final List<String> newLetters_2 = new ArrayList<>();
        for (String i : Letters_2) {
            newLetters_2.add(i);
        }
        final List<String> newLetters_3 = new ArrayList<>();
        for (String i : Letters_3) {
            newLetters_3.add(i);
        }

        letterModels = new ArrayList<>();
        for (int i = 0; i < LettersImages.length; i++) {
            LettersModel model = new LettersModel(LettersImages[i], LettersNames[i]);
            letterModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityLetters.this,
                LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        lettersAdapter = new LettersAdapter(ActivityLetters.this, letterModels);
        lettersAdapter.setOnitemclicklistener(ActivityLetters.this);

        lettersAdapter.setOnitemclicklistener(new LettersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Position = position;
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
        lettername = MediaPlayer.create(this, lettterAudio[Position]);
        letteraudioatbegin = MediaPlayer.create(this, R.raw.letteratbegin);
        letteraudioatmiddle = MediaPlayer.create(this, R.raw.letteratmiddle);
        letteraudioatend = MediaPlayer.create(this, R.raw.letteratend);
        letteraudio_1 = MediaPlayer.create(this, letterAudio_1[Position]);
        letteraudio_2 = MediaPlayer.create(this, letterAudio_2[Position]);
        letteraudio_3 = MediaPlayer.create(this, letterAudio_3[Position]);
        recyclerView.setAdapter(lettersAdapter);

    }

    public void openDialog() {
        index = LettersNames[Position];
        UploadDialog uploadDialog = new UploadDialog();
        uploadDialog.show(getSupportFragmentManager(), "upload dialog");
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, ActivityLetters.class);
    }

    public void onBackPressed() {
        OpenActivityStarting();
    }

    public void OpenActivityStarting() {
        Intent openactivitystarting = new Intent(this, StartingActivity.class);
        startActivity(openactivitystarting);
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

    public void letterimage(View view) {
        lettername = MediaPlayer.create(this, lettterAudio[Position]);
        lettername.start();
    }

    public void letteratend(View view) {
        letteraudioatend.start();
    }

    public void letteratmiddle(View view) {
        letteraudioatmiddle.start();
    }

    public void letteratbegin(View view) {
        letteraudioatbegin.start();
    }

    public void letter3(View view) {
        letteraudio_3 = MediaPlayer.create(this, letterAudio_3[Position]);
        if (Position < 27) {
            letteraudio_3.start();
        } else {
        }
    }

    public void letter2(View view) {
        if (Position < 26) {
            letteraudio_2 = MediaPlayer.create(this, letterAudio_2[Position]);
            letteraudio_2.start();
        }
        if (Position == 27) {
            letteraudio_2 = MediaPlayer.create(this, letterAudio_2[26]);
            letteraudio_2.start();
        }
    }

    public void letter1(View view) {
        letteraudio_1 = MediaPlayer.create(this, letterAudio_1[Position]);
        letteraudio_1.start();
    }

    public void forward(View view) {
        OpenActivityFirstExercise();
    }

    public void OpenActivityFirstExercise() {
        Intent openactivityfirstexercies = new Intent(this, ActivityFirstExercise.class);
        startActivity(openactivityfirstexercies);
    }
}