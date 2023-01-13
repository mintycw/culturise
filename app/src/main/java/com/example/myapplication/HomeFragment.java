package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private AppManager m_AppManager;
    private FragmentHomeBinding m_Binding;

    private ImageButton m_ActivityOfTheDayButton;
    private ArrayList<Cultures> m_CulturesArrayList;
    private int[] m_ImageResource;
    private RecyclerView m_RecyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        m_Binding = FragmentHomeBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_AppManager = AppManager.getInstance();
        initializeRecyclerView();
        activityOfTheDay();
    }

    private void activityOfTheDay() {
        m_ActivityOfTheDayButton = getView().findViewById(R.id.activityOfTheDayButton);

        int randomCultureIndex = getRandomNumber(0, m_CulturesArrayList.size() - 2);
        int randomCategoryIndex = getRandomNumber(0, 2);

        m_AppManager.returnActivity(getContext(), randomCultureIndex, randomCategoryIndex);
        int randomActivityIndex = getRandomNumber(0, m_AppManager.m_Activity.length);

        m_ActivityOfTheDayButton.setImageResource(m_AppManager.m_Activity[randomActivityIndex]);
        m_ActivityOfTheDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityOfTheDay.class);
                intent.putExtra("activityIndex", randomActivityIndex);
                startActivity(intent);
            }
        });
    }

    private void initializeRecyclerView() {
        m_CulturesArrayList = new ArrayList<Cultures>();

        m_ImageResource = new int[] {
                R.drawable.flag_china,
                R.drawable.flag_italy,
                R.drawable.flag_japan,
                R.drawable.flag_turkey,
                R.drawable.flag_spain,
        };

        for (int i = 0; i < m_ImageResource.length; i++) {
            Cultures cultures = new Cultures(m_ImageResource[i]);
            m_CulturesArrayList.add(cultures);
        }

        m_RecyclerView = getView().findViewById(R.id.flagRecycler);
        m_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        m_RecyclerView.setHasFixedSize(true);
        FlagAdapter flagAdapter = new FlagAdapter(getContext(), m_CulturesArrayList);
        m_RecyclerView.setAdapter(flagAdapter);
        flagAdapter.notifyDataSetChanged();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }
}