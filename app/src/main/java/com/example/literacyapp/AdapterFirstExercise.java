package com.example.literacyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFirstExercise extends RecyclerView.Adapter<AdapterFirstExercise.ViewHolder> {
    ArrayList<ModelFirstExercise> modelFirstExercise;
    Context contextfirstexercise;
    OnItemClickListener onitemclicklistener;

    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnitemclicklistener (OnItemClickListener listener){
        onitemclicklistener = listener;
    }
    public AdapterFirstExercise(Context contextfirstexercise, ArrayList<ModelFirstExercise> modelFirstExercise){
        this.contextfirstexercise = contextfirstexercise;
        this.modelFirstExercise = modelFirstExercise;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firstexercise,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(modelFirstExercise.get(position).getWordsImages());
        holder.textView.setText(modelFirstExercise.get(position).getWords());
    }

    @Override
    public int getItemCount() {
        return modelFirstExercise.size();
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
