package com.example.literacyapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.literacyapp.Models.FourthExerciseModel;
import com.example.literacyapp.R;

import java.util.ArrayList;

public class FourthExerciseAdapter extends RecyclerView.Adapter<FourthExerciseAdapter.ViewHolder> {
    ArrayList<FourthExerciseModel> fourthExerciseModel;
    Context context;
    FourthExerciseAdapter.OnItemClickListener onitemclicklistener;

    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnitemclicklistener (FourthExerciseAdapter.OnItemClickListener listener){
        onitemclicklistener = listener;
    }
    public FourthExerciseAdapter(Context context, ArrayList<FourthExerciseModel> fourthExerciseModel) {
        this.context = context;
        this.fourthExerciseModel = fourthExerciseModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fourthexercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(fourthExerciseModel.get(position).getQusetions());
    }

    @Override
    public int getItemCount() {
        return fourthExerciseModel.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
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
