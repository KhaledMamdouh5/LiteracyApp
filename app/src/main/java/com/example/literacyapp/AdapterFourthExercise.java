package com.example.literacyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFourthExercise extends RecyclerView.Adapter<AdapterFourthExercise.ViewHolder> {
    ArrayList<ModelFourthExercise> modelFourthExercise;
    Context contextfourthexercise;
    AdapterFourthExercise.OnItemClickListener onitemclicklistener;

    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnitemclicklistener (AdapterFourthExercise.OnItemClickListener listener){
        onitemclicklistener = listener;
    }

    public AdapterFourthExercise(Context contextfourthexercise, ArrayList<ModelFourthExercise> modelFourthExercise){
        this.contextfourthexercise = contextfourthexercise;
        this.modelFourthExercise = modelFourthExercise;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fourthexercise,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(modelFourthExercise.get(position).getWordsImages());

    }

    @Override
    public int getItemCount() {
        return modelFourthExercise.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_fourth_exercise);
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
