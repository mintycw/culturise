package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentSelectedBinding;

import java.util.ArrayList;

public class SelectedFragment extends Fragment {

    private AppManager m_IndexSingleton;
    private FragmentSelectedBinding m_Binding;

    private ImageView m_Background;

    private int m_CultureIndex;
    private int m_CategoryIndex;
    private String[] m_Category;

    private int[] m_ImageResource;
    private String[] m_ActivityPlace;
    private String[] m_ActivityAddress;
    private ArrayList<Activities> m_ActivitiesArrayList;
    private RecyclerView m_RecyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        m_Binding = FragmentSelectedBinding.inflate(inflater, container, false);
        m_IndexSingleton = AppManager.getInstance();

        m_CultureIndex = m_IndexSingleton.returnCultureIndex();
        m_CategoryIndex = m_IndexSingleton.returnCategoryIndex();

        return m_Binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_Background = view.findViewById(R.id.selectedBackground);
        setBackground();
        initializeRecyclerView();
        setText();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

    private void setBackground() {
        switch (m_CultureIndex) {
            case 0:
                m_Background.setImageResource(R.drawable.china_activity_background);
                break;
            case 1:
                m_Background.setImageResource(R.drawable.italy_activity_background);
                break;
            case 2:
                m_Background.setImageResource(R.drawable.japan_activity_background);
                break;
            case 3:
                m_Background.setImageResource(R.drawable.turkey_activity_background);
                break;
            case 4:
                m_Background.setImageResource(R.drawable.spain_activity_background);
                break;
        }
    }

    private void setText() {
        TextView categoryText = getView().findViewById(R.id.selectedCategory);
        TextView amountText = getView().findViewById(R.id.selectedAmount);
        m_Category = m_IndexSingleton.returnCategory();
        String amount = Integer.toString(m_ImageResource.length);

        categoryText.setText(m_Category[m_CategoryIndex]);
        amountText.setText(amount + " gevonden in Rotterdam");
    }

    private void initializeRecyclerView() {
        m_ImageResource = m_IndexSingleton.returnActivity(getContext(), m_CultureIndex, m_CategoryIndex);
        m_ActivityPlace = m_IndexSingleton.returnActivityPlace();
        m_ActivityAddress = m_IndexSingleton.returnActivityAddress();

        m_ActivitiesArrayList = new ArrayList<Activities>();

        for (int i = 0; i < m_ImageResource.length; i++) {
            Activities activities = new Activities(m_ImageResource[i], m_ActivityPlace[i], m_ActivityAddress[i]);
            m_ActivitiesArrayList.add(activities);
        }

        m_RecyclerView = getView().findViewById(R.id.selectedRecycler);
        m_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        m_RecyclerView.setHasFixedSize(true);
        ActivityAdapter activityAdapter = new ActivityAdapter(getContext(), m_ActivitiesArrayList);
        m_RecyclerView.setAdapter(activityAdapter);
        activityAdapter.notifyDataSetChanged();
    }
}