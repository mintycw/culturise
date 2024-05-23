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

/**
 * A fragment to display selected category activities.
 */
public class SelectedFragment extends Fragment {

    private AppManager m_AppManager;
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

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_Binding = FragmentSelectedBinding.inflate(inflater, container, false);
        m_AppManager = AppManager.getInstance();

        m_CultureIndex = m_AppManager.returnCultureIndex();
        m_CategoryIndex = m_AppManager.returnCategoryIndex();

        return m_Binding.getRoot();
    }

    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned, but before any saved state has been restored in to the view.
     *
     * @param view               The View returned by onCreateView(LayoutInflater, ViewGroup, Bundle).
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_Background = view.findViewById(R.id.selectedBackground);
        setBackground();
        initializeRecyclerView();
        setText();
    }

    /**
     * Called when the view previously created by onCreateView(LayoutInflater, ViewGroup, Bundle) has been detached from the fragment.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

    /**
     * Sets the background image based on the culture index.
     */
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

    /**
     * Sets the text for category and amount of activities found.
     */
    private void setText() {
        TextView categoryText = getView().findViewById(R.id.selectedCategory);
        TextView amountText = getView().findViewById(R.id.selectedAmount);
        m_Category = m_AppManager.returnCategory();
        String amount = Integer.toString(m_ImageResource.length);

        categoryText.setText(m_Category[m_CategoryIndex]);
        amountText.setText(amount + " gevonden in Rotterdam");
    }

    /**
     * Initializes the RecyclerView to display activities.
     */
    private void initializeRecyclerView() {
        m_ImageResource = m_AppManager.returnActivity(getContext(), m_CultureIndex, m_CategoryIndex);
        m_ActivityPlace = m_AppManager.returnActivityPlace();
        m_ActivityAddress = m_AppManager.returnActivityAddress();

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
