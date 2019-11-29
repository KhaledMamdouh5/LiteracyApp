package com.example.literacyapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.literacyapp.Models.UserProfile;
import com.example.literacyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword, txtConfirmPassword;
    Button btn_register;
    RadioButton yes, no;
    LinearLayout l;
    ProgressBar progressBar;
    TextView txtView;
    private FirebaseAuth firebaseAuth;
    EditText username;
    String usertype = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        username = findViewById(R.id.usernuuuuuuuuame);

        txtEmail = findViewById(R.id.email);
        txtPassword = findViewById(R.id.password);
        txtView = findViewById(R.id.txtView);
        txtConfirmPassword = findViewById(R.id.confirmpassword);
        btn_register = findViewById(R.id.buttonregister);
        progressBar = findViewById(R.id.progressBar);
        l = findViewById(R.id.studentframe);
        l.setVisibility(l.INVISIBLE);

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("profiles");

        yes = findViewById(R.id.studentradio);
        no = findViewById(R.id.teacherradio);
        firebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(confirmPassword)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {

                                        UserProfile profile = new UserProfile(usertype,
                                                FirebaseAuth.getInstance().getCurrentUser().getUid(),
                                                username.getText().toString(),
                                                null
                                        );
                                        String key = reference.push().getKey();
                                        reference.child(key).setValue(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful())
                                                    Toast.makeText(RegisterActivity.this, "profile created", Toast.LENGTH_SHORT).show();
                                                else
                                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(username.getText().toString())
                                                .build();
                                        if (usertype.equals("1")) {
                                            Intent intent = new Intent(RegisterActivity.this, StartingActivity.class);
                                            intent.putExtra("n", username.getText().toString());
                                            startActivity(intent);
                                        }
                                        if (usertype.equals("2")) {
                                            Intent intent = new Intent(RegisterActivity.this, ActivityMentor.class);
                                            intent.putExtra("n", username.getText().toString());
                                            startActivity(intent);
                                        }
                                        Toast.makeText(RegisterActivity.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(i);
            }
        });

        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes.isChecked()) {
                    usertype = "1";
                    l.setVisibility(l.VISIBLE);
                }
            }
        });

        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no.isChecked()) {
                    usertype = "2";
                    l.setVisibility(l.VISIBLE);
                }
            }
        });
    }
}