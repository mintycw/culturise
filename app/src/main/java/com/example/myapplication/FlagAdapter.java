package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * Adapter class for populating a RecyclerView with culture flags.
 */
public class FlagAdapter extends RecyclerView.Adapter<FlagAdapter.FlagViewHolder> {

    private Context m_Context;
    private ArrayList<Cultures> m_CulturesArrayList;

    /**
     * Constructs a new FlagAdapter with the given context and list of culture flags.
     *
     * @param context             The context of the activity.
     * @param culturesArrayList The list of culture flags to be displayed.
     */
    public FlagAdapter(Context context, ArrayList<Cultures> culturesArrayList) {
        this.m_Context = context;
        this.m_CulturesArrayList = culturesArrayList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    @NonNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_Context).inflate(R.layout.item_culture, parent, false);
        return new FlagViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    @Override
    public void onBindViewHolder(@NonNull FlagViewHolder holder, int position) {
        Cultures cultures = m_CulturesArrayList.get(position);
        holder.flagButton.setImageResource(cultures.m_CultureImage);
        holder.flagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start CategoryActivity when culture flag is clicked
                Intent intent = new Intent(m_Context, CategoryActivity.class);
                intent.putExtra("index", holder.getAdapterPosition());
                m_Context.startActivity(intent);
            }
        });
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return m_CulturesArrayList.size();
    }

    /**
     * ViewHolder class for caching View components of the culture flag item layout.
     */
    public static class FlagViewHolder extends RecyclerView.ViewHolder {
        ImageButton flagButton;
        ConstraintLayout layout;

        /**
         * Constructs a new FlagViewHolder to hold the view components.
         */
        public FlagViewHolder(@NonNull View itemView) {
            super(itemView);
            flagButton = itemView.findViewById(R.id.flagButton);
            layout = itemView.findViewById(R.id.flagRecyclerItem);
        }
    }
}
