package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;

/**
 * Fragment for displaying the home screen content.
 */
public class HomeFragment extends Fragment {

    private AppManager m_AppManager;
    private FragmentHomeBinding m_Binding;

    private ImageButton m_ActivityOfTheDayButton;
    private ArrayList<Cultures> m_CulturesArrayList;
    private int[] m_ImageResource;
    private RecyclerView m_RecyclerView;

    /**
     * Called to have the fragment instantiate its user interface view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        m_Binding = FragmentHomeBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();
    }

    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned,
     * but before any saved state has been restored in to the view.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_AppManager = AppManager.getInstance();
        initializeRecyclerView();
        activityOfTheDay();
    }

    /**
     * Sets up the "Activity of the Day" button functionality.
     */
    private void activityOfTheDay() {
        m_ActivityOfTheDayButton = getView().findViewById(R.id.activityOfTheDayButton);

        // Generate random indices for culture, category, and activity
        int randomCultureIndex = getRandomNumber(0, m_CulturesArrayList.size() - 2);
        int randomCategoryIndex = getRandomNumber(0, 2);

        // Retrieve a random activity for the day
        m_AppManager.returnActivity(getContext(), randomCultureIndex, randomCategoryIndex);
        int randomActivityIndex = getRandomNumber(0, m_AppManager.m_Activity.length);

        // Set the randomly selected activity as the image for the button
        m_ActivityOfTheDayButton.setImageResource(m_AppManager.m_Activity[randomActivityIndex]);
        m_ActivityOfTheDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start ActivityOfTheDay activity with information about the selected activity
                Intent intent = new Intent(getContext(), ActivityOfTheDay.class);
                intent.putExtra("activityIndex", randomActivityIndex);
                startActivity(intent);
            }
        });
    }

    /**
     * Initializes the RecyclerView for displaying culture flags.
     */
    private void initializeRecyclerView() {
        m_CulturesArrayList = new ArrayList<Cultures>();

        // Initialize array of culture flag images
        m_ImageResource = new int[] {
                R.drawable.flag_china,
                R.drawable.flag_italy,
                R.drawable.flag_japan,
                R.drawable.flag_turkey,
                R.drawable.flag_spain,
        };

        // Populate the ArrayList with Cultures objects
        for (int i = 0; i < m_ImageResource.length; i++) {
            Cultures cultures = new Cultures(m_ImageResource[i]);
            m_CulturesArrayList.add(cultures);
        }

        // Set up the RecyclerView
        m_RecyclerView = getView().findViewById(R.id.flagRecycler);
        m_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        m_RecyclerView.setHasFixedSize(true);
        FlagAdapter flagAdapter = new FlagAdapter(getContext(), m_CulturesArrayList);
        m_RecyclerView.setAdapter(flagAdapter);
        flagAdapter.notifyDataSetChanged();
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param min The minimum value of the range (inclusive).
     * @param max The maximum value of the range (exclusive).
     * @return A random integer within the specified range.
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Called when the view previously created by onCreateView(LayoutInflater, ViewGroup, Bundle)
     * has been detached from the fragment.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }
}
