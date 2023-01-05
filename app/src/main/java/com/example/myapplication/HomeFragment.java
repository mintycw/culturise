package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding m_Binding;
    private ArrayList<Cultures> m_CulturesArrayList;
    private int[] m_ImageResource;
    private String[] m_Cultures;
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

        initializeRecyclerView();
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

        m_Cultures = getResources().getStringArray(R.array.culture_names);

        for (int i = 0; i < m_ImageResource.length; i++) {
            Cultures cultures = new Cultures(m_ImageResource[i]);
            m_CulturesArrayList.add(cultures);
        }

        m_RecyclerView = getView().findViewById(R.id.flagRecycler);
        m_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        m_RecyclerView.setHasFixedSize(true);
        FlagAdapter flagAdapter = new FlagAdapter(getContext(), m_CulturesArrayList, m_Cultures);
        m_RecyclerView.setAdapter(flagAdapter);
        flagAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }
}