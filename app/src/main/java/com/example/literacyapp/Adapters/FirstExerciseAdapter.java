package com.example.literacyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.literacyapp.Models.FirstExerciseModel;
import com.example.literacyapp.R;

import java.util.ArrayList;

public class FirstExerciseAdapter extends RecyclerView.Adapter<FirstExerciseAdapter.ViewHolder> {
    ArrayList<FirstExerciseModel> firstExerciseModel;
    Context contextfirstexercise;
    OnItemClickListener onitemclicklistener;

    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnitemclicklistener (OnItemClickListener listener){
        onitemclicklistener = listener;
    }
    public FirstExerciseAdapter(Context contextfirstexercise, ArrayList<FirstExerciseModel> firstExerciseModel){
        this.contextfirstexercise = contextfirstexercise;
        this.firstExerciseModel = firstExerciseModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firstexercise,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(firstExerciseModel.get(position).getWordsImages());
        holder.textView.setText(firstExerciseModel.get(position).getWords());
    }

    @Override
    public int getItemCount() {
        return firstExerciseModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_first_exercise);
            textView = itemView.findViewById(R.id.text_view_first_exercise);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onitemclicklistener !=null){
                        int position = getAdapterPosition();
                        if (position !=RecyclerView.NO_POSITION){
                            onitemclicklistener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
