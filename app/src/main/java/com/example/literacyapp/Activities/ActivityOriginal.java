package com.example.literacyapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.literacyapp.Models.QuestionModel;
import com.example.literacyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class ActivityOriginal extends AppCompatActivity {
    private Button mUploadBtn;
    private ImageView mImageView;
    private Button mCaptureBtn;
    private static final int Camera_Request_Code = 1;
    public static StorageReference storageReference;
    public static String uploadedImageUrl;
    public static String usernameeeeeee;
    ImageView mentorimage;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usernameeeeeee=getIntent().getStringExtra("n");

        setContentView(R.layout.activity_original);


        storageReference = FirebaseStorage.getInstance().getReference();
        mImageView = (ImageView) findViewById(R.id.imageCapture);
        mUploadBtn = (Button) findViewById(R.id.btn_upload);
        mentorimage=(ImageView)findViewById(R.id.image_view);
        mCaptureBtn = (Button) findViewById(R.id.btn_capture);
        mUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Camera_Request_Code);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap = (Bitmap) data.getExtras().get("data");
        mImageView.setImageBitmap(bitmap);
    }

    public void onBackPressed() {
        Intent closeApp = new Intent(Intent.ACTION_MAIN);
        closeApp.addCategory(Intent.CATEGORY_HOME);
        closeApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(closeApp);
    }
}
