package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private Context m_Context;
    private ArrayList<Activities> m_ActivityArrayList;

    public ActivityAdapter(Context context, ArrayList<Activities> activityArrayList) {
        this.m_Context = context;
        this.m_ActivityArrayList = activityArrayList;
    }

    @NonNull
    @Override
    public ActivityAdapter.ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_Context).inflate(R.layout.item_activity, parent, false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ActivityViewHolder holder, int position) {
        Activities activities = m_ActivityArrayList.get(position);
        holder.activityImage.setImageResource(activities.m_ActivityImage);
        holder.activityPlace.setText(activities.m_ActivityPlace);
        holder.activityAddress.setText(activities.m_ActivityAddress);
    }

    @Override
    public int getItemCount() {
        return m_ActivityArrayList.size();
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder {

        ImageView activityImage;
        TextView activityPlace;
        TextView activityAddress;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            activityImage = itemView.findViewById(R.id.activityImage);
            activityPlace = itemView.findViewById(R.id.activityPlace);
            activityAddress = itemView.findViewById(R.id.activityAddress);
        }
    }
}
