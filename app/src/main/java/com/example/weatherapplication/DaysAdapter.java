package com.example.weatherapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysViewHolder> {

    private List<String> days;
    public void setDays(List<String> days){
        this.days = days;
        notifyDataSetChanged();
    }

    public void justSetDays(List<String> days){
    this.days = days;
    }

    @NonNull
    @Override
    public DaysViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        return new DaysViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_days, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DaysViewHolder holder, int position) {
        holder.bind(days.get(position));
    }

    @Override
    public int getItemCount() {
        if (days == null) return 0;
        else {
            return days.size();
        }

    }

    static class DaysViewHolder extends RecyclerView.ViewHolder{

        // метод наполнения информацией строк с днями (так правильнее, больше оптимизирован)
        private final TextView textView;
        public DaysViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.daysTextView);
        }

        void bind(String days){
           textView.setText(days);
        }
    }
}
