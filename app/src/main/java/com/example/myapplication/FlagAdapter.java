package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlagAdapter extends RecyclerView.Adapter<FlagAdapter.FlagViewHolder> {

    private Context m_Context;
    private ArrayList<Cultures> m_CulturesArrayList;
    private String[] m_Cultures;

    public FlagAdapter(Context context, ArrayList<Cultures> culturesArrayList, String[] cultures) {
        this.m_Context = context;
        this.m_CulturesArrayList = culturesArrayList;
        this.m_Cultures = cultures;
    }

    @NonNull
    @Override
    public FlagAdapter.FlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(m_Context).inflate(R.layout.culture_item, parent, false);
        return new FlagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlagAdapter.FlagViewHolder holder, int position) {
        Cultures cultures = m_CulturesArrayList.get(position);
        holder.flagButton.setImageResource(cultures.cultureImage);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
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
        return m_CulturesArrayList.size();
    }

    public static class FlagViewHolder extends RecyclerView.ViewHolder {

        ImageView flagButton;
        ConstraintLayout itemLayout;

        public FlagViewHolder(@NonNull View itemView) {
            super(itemView);
            flagButton = itemView.findViewById(R.id.flagViewButton);
            itemLayout = itemView.findViewById(R.id.flagRecyclerItem);
        }
    }
}