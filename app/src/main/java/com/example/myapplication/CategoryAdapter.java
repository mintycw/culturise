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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context m_Context;
    private ArrayList<Categories> m_CategoriesArrayList;

    public CategoryAdapter(Context context, ArrayList<Categories> categoriesArrayList) {
        this.m_Context = context;
        this.m_CategoriesArrayList = categoriesArrayList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_Context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Categories categories = m_CategoriesArrayList.get(position);
        holder.title.setText(categories.m_CategoryText);
        holder.imageButton.setImageResource(categories.m_CategoryImage);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(m_Context, SelectedActivity.class);
                intent.putExtra("index", holder.getAdapterPosition());
                m_Context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return m_CategoriesArrayList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageButton;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.categoryText);
            imageButton = itemView.findViewById(R.id.activityImage);
        }
    }
}