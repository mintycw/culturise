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

/**
 * Adapter class for populating a RecyclerView with activity items.
 */
public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private Context m_Context;
    private ArrayList<Activities> m_ActivityArrayList;

    /**
     * Constructs a new ActivityAdapter with the given context and list of activities.
     *
     * @param context           The context of the activity.
     * @param activityArrayList The list of activities to be displayed.
     */
    public ActivityAdapter(Context context, ArrayList<Activities> activityArrayList) {
        this.m_Context = context;
        this.m_ActivityArrayList = activityArrayList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    @NonNull
    @Override
    public ActivityAdapter.ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_Context).inflate(R.layout.item_activity, parent, false);
        return new ActivityViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ActivityViewHolder holder, int position) {
        Activities activities = m_ActivityArrayList.get(position);
        holder.activityImage.setImageResource(activities.m_ActivityImage);
        holder.activityPlace.setText(activities.m_ActivityPlace);
        holder.activityAddress.setText(activities.m_ActivityAddress);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return m_ActivityArrayList.size();
    }

    /**
     * ViewHolder class for caching View components of the item layout.
     */
    public static class ActivityViewHolder extends RecyclerView.ViewHolder {

        ImageView activityImage;
        TextView activityPlace;
        TextView activityAddress;

        /**
         * Constructs a new ActivityViewHolder to hold the view components.
         */
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            activityImage = itemView.findViewById(R.id.activityImage);
            activityPlace = itemView.findViewById(R.id.activityPlace);
            activityAddress = itemView.findViewById(R.id.activityAddress);
        }
    }
}
