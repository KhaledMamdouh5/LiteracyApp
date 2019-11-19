package com.example.literacyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSecondExercise extends RecyclerView.Adapter<AdapterSecondExercise.ViewHolder> {
    ArrayList<ModelSecondExercise> modelSecondExercise;
    Context contextthirdexercise;
    OnItemClickListener onitemclicklistener;


    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnitemclicklistener (OnItemClickListener listener){
        onitemclicklistener = listener;
    }
    public AdapterSecondExercise(Context contextthirdexercise, ArrayList<ModelSecondExercise> modelSecondExercise){
        this.contextthirdexercise = contextthirdexercise;
        this.modelSecondExercise = modelSecondExercise;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thirdexercise,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(modelSecondExercise.get(position).getWordsImages());
    }

    @Override
    public int getItemCount() {
        return modelSecondExercise.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_third_exercise);
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
