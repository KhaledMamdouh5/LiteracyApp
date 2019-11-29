package com.example.literacyapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.literacyapp.Activities.ActivityFirstExercise;
import com.example.literacyapp.Activities.ActivityFourthExercise;
import com.example.literacyapp.Activities.ActivityLetters;
import com.example.literacyapp.Activities.ActivityN1_10;
import com.example.literacyapp.Activities.ActivityOriginal;
import com.example.literacyapp.Models.QuestionModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import static com.example.literacyapp.R.*;
import static com.example.literacyapp.R.raw.*;


public class UploadDialog extends AppCompatDialogFragment {
    private ImageView imageView;
    Bitmap bitmap;
    Button button;
    public static StorageReference storageReference;
    public static String uploadedImageUrl;
    public static String usernameeeeeee;
    MediaPlayer image_sent_successfully;
    MediaPlayer sending_failed;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        storageReference = FirebaseStorage.getInstance().getReference();
        switch (getActivity().getClass().getSimpleName()) {
            case "ActivityLetters":
                bitmap = ActivityLetters.bitmap;
                break;

            case "ActivityN1_10":
                bitmap = ActivityN1_10.bitmap;
                break;

            case "ActivityFirstExercise":
                bitmap = ActivityFirstExercise.bitmap;
                break;

            case "ActivityFourthExercise":
                bitmap = ActivityFourthExercise.bitmap;
                break;

        }

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(layout.upload, null);
        builder.setView(view)
                .setTitle("إرسال الصورة")
                .setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        imageView = view.findViewById(id.uploadimage);
        imageView.setImageBitmap(bitmap);
        button = view.findViewById(id.button_upload);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setTitle("يتم الإرسال الآن...");
                progressDialog.show();
                final StorageReference riversRef = storageReference.child("images/" + System.currentTimeMillis());

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
                byte[] data = baos.toByteArray();
                UploadTask uploadTask = riversRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(getContext(), "Failed to upload!", Toast.LENGTH_SHORT).show();
                        // Handle unsuccessful uploads
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //the link of the uploaded image
                        riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                uploadedImageUrl = uri.toString();

                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("sentImages");
                                String key = reference.push().getKey();

                                QuestionModel model = new QuestionModel(uploadedImageUrl,
                                        usernameeeeeee,
                                        null, ActivityLetters.index);

                                QuestionModel model_1 = new QuestionModel(uploadedImageUrl,
                                        usernameeeeeee,
                                        null, ActivityN1_10.index);

                                QuestionModel model_2 = new QuestionModel(uploadedImageUrl,
                                        usernameeeeeee,
                                        null, ActivityFourthExercise.index);

                                QuestionModel model_3 = new QuestionModel(uploadedImageUrl,
                                        usernameeeeeee,
                                        null, ActivityFirstExercise.index);

                                reference.child(key).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                            Toast.makeText(getContext(), "Image sent", Toast.LENGTH_SHORT).show();

                                    }
                                });

                                reference.child(key).setValue(model_1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                            Toast.makeText(getContext(), "Image sent", Toast.LENGTH_SHORT).show();

                                    }

                                });
                                reference.child(key).setValue(model_2).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                            Toast.makeText(getContext(), "Image sent", Toast.LENGTH_SHORT).show();

                                    }

                                });
                                reference.child(key).setValue(model_3).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                            Toast.makeText(getContext(), "Image sent", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        });

                        Toast.makeText(getContext(), "Uploaded Successfully", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

            }

        });
        return builder.create();
    }
}
