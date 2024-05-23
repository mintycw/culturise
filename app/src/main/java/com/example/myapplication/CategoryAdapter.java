package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * Adapter class for populating a RecyclerView with category items.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context m_Context;
    private ArrayList<Categories> m_CategoriesArrayList;

    /**
     * Constructs a new CategoryAdapter with the given context and list of categories.
     *
     * @param context             The context of the activity.
     * @param categoriesArrayList The list of categories to be displayed.
     */
    public CategoryAdapter(Context context, ArrayList<Categories> categoriesArrayList) {
        this.m_Context = context;
        this.m_CategoriesArrayList = categoriesArrayList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_Context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Categories categories = m_CategoriesArrayList.get(position);
        holder.title.setText(categories.m_CategoryText);
        holder.imageButton.setImageResource(categories.m_CategoryImage);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start SelectedActivity when category item is clicked
                Intent intent = new Intent(m_Context, SelectedActivity.class);
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
        return m_CategoriesArrayList.size();
    }

    /**
     * ViewHolder class for caching View components of the category item layout.
     */
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageButton;

        /**
         * Constructs a new CategoryViewHolder to hold the view components.
         */
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.categoryText);
            imageButton = itemView.findViewById(R.id.activityImage);
        }
    }
}
