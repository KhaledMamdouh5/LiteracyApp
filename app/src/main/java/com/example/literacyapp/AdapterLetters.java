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

public class AdapterLetters extends RecyclerView.Adapter<AdapterLetters.ViewHolder> {
    ArrayList<ModelLetters> modelLetters;
    Context context;
    OnItemClickListener onitemclicklistener;
    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnitemclicklistener (OnItemClickListener listener){
        onitemclicklistener = listener;
    }
    public AdapterLetters(Context context, ArrayList<ModelLetters> modelLetters){
        this.context = context;
        this.modelLetters = modelLetters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.letters,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(modelLetters.get(position).getLettersImages());
        holder.textView.setText(modelLetters.get(position).getLettersNames());
    }

    @Override
    public int getItemCount() {
        return modelLetters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
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
