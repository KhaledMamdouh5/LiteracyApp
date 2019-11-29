package com.example.literacyapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.literacyapp.Models.QuestionModel;
import com.example.literacyapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityMentor extends AppCompatActivity {
    //  RecyclerView recyclerView;
    //  ArrayList<ModelMentor> modelMentor;
    //  AdapterMentor adapterMentor;
    TextView mentormessage;
    ImageView downloadedImage, mentorimage;
    Button show;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor);
        //  recyclerView = findViewById(R.id.recycler_view);
        mentormessage = findViewById(R.id.text_view);
        show = findViewById(R.id.Comment);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatase.getReference(firebaseAuth.getUid());
        downloadedImage = findViewById(R.id.image_view);
        downloadedImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mentormenu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mentorlist, mentormenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mentor_list:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LogInActivity.class));
        }
        return true;
    }

    private void downloadedImage() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("sentImages");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    final QuestionModel model = dataSnapshot1.getValue(QuestionModel.class);

                    if (model.getUrl() != null) {
                        show.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Glide.with(ActivityMentor.this).load(model.getUrl()).placeholder(R.drawable.arm).into(downloadedImage);
                                mentormessage.setText(model.getLetter());
                            }
                        });
                    } else
                        downloadedImage.setImageResource(R.drawable.arm);
                }
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    final QuestionModel model_l = dataSnapshot1.getValue(QuestionModel.class);

                    if (model_l.getUrl() != null) {
                        show.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Glide.with(ActivityMentor.this).load(model_l.getUrl()).placeholder(R.drawable.arm).into(downloadedImage);
                                mentormessage.setText(model_l.getLetter());
                            }
                        });
                    } else
                        downloadedImage.setImageResource(R.drawable.arm);
                }
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    final QuestionModel model_2 = dataSnapshot1.getValue(QuestionModel.class);

                    if (model_2.getUrl() != null) {
                        show.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Glide.with(ActivityMentor.this).load(model_2.getUrl()).placeholder(R.drawable.arm).into(downloadedImage);
                                mentormessage.setText(model_2.getLetter());
                            }
                        });
                    } else
                        downloadedImage.setImageResource(R.drawable.arm);
                }
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    final QuestionModel model_3 = dataSnapshot1.getValue(QuestionModel.class);

                    if (model_3.getUrl() != null) {
                        show.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Glide.with(ActivityMentor.this).load(model_3.getUrl()).placeholder(R.drawable.arm).into(downloadedImage);
                                mentormessage.setText(model_3.getLetter());
                            }
                        });
                    } else
                        downloadedImage.setImageResource(R.drawable.arm);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //  LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityMentor.this,
        //         LinearLayoutManager.VERTICAL, false);
        //  recyclerView.setLayoutManager(layoutManager);
        //  recyclerView.setItemAnimator(new DefaultItemAnimator());
        //  recyclerView.setAdapter(adapterMentor);
    }

    public void onBackPressed() {
        Intent closeApp = new Intent(Intent.ACTION_MAIN);
        closeApp.addCategory(Intent.CATEGORY_HOME);
        closeApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(closeApp);
    }
}
