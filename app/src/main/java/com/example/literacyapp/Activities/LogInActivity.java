package com.example.literacyapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.literacyapp.Models.UserProfile;
import com.example.literacyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    Button btn_login;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_activity);
        txtEmail=(EditText)findViewById(R.id.edittexrem);
        txtPassword=(EditText)findViewById(R.id.edittextpass);
        btn_login=(Button)findViewById(R.id.buttonlogin);
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtEmail.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LogInActivity.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LogInActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(LogInActivity.this,"Password too short",Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull final Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("profiles");
                                    reference.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                                final UserProfile userProfile= dataSnapshot1.getValue(UserProfile.class);

                                                if (userProfile.getUserType().equals("1")) {
                                                    Intent intent = new Intent(LogInActivity.this, StartingActivity.class);
                                                    startActivity(intent);
                                                }
                                                else if (userProfile.getUserType().equals("2")) {
                                                    Intent intent = new Intent(LogInActivity.this, ActivityMentor.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                }
                                else {
                                    Toast.makeText(LogInActivity.this,"Login failed or User not available",Toast.LENGTH_SHORT).show();

                                }

                            }
                        });

            }
        });
        TextView register=(TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}