package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.databinding.FragmentCategoryBinding;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private IndexSingleton m_IndexSingleton;
    private FragmentCategoryBinding m_Binding;

    private ImageView m_Background;
    private int m_Index;
    private int[] m_ImageResource;
    private ArrayList<Categories> m_CategoriesArrayList;
    private RecyclerView m_RecyclerView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        m_IndexSingleton = IndexSingleton.getInstance();
        m_Index = m_IndexSingleton.returnCultureIndex();
        m_Binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_Background = view.findViewById(R.id.categoryBackground);
        setCulture();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

    private void setCulture() {
        switch (m_Index) {
            case 0:
                m_Background.setImageResource(R.drawable.china_background);
                m_ImageResource = new int[] {
                        R.drawable.oriental_express,
                        R.drawable.amazing_oriental_rotterdam_centrum,
                        R.drawable.qq_bakery,
                };
                m_IndexSingleton.m_Category = getResources().getStringArray(R.array.china_activities);

                initializeRecyclerView();
                setText(false);

                break;
            case 1:
                m_Background.setImageResource(R.drawable.italy_background);
                m_ImageResource = new int[] {
                        R.drawable.ristorante_pizzeria_messina,
                        R.drawable.little_italy,
                        R.drawable.coco_cheri,
                        R.drawable.gusto_italiano,
                };
                m_IndexSingleton.m_Category = getResources().getStringArray(R.array.italy_activities);

                initializeRecyclerView();
                setText(true);

                break;
            case 2:
                m_Background.setImageResource(R.drawable.japan_background);
                m_ImageResource = new int[] {
                        R.drawable.happy_mango,
                        R.drawable.osozai,
                        R.drawable.kazaguruma,
                };
                m_IndexSingleton.m_Category = getResources().getStringArray(R.array.japan_activities);

                initializeRecyclerView();
                setText(true);

                break;
        }
    }

    private void setText(boolean black) {
        String introHeader[] = getResources().getStringArray(R.array.culture_welcome_header);
        String introDescription[] = getResources().getStringArray(R.array.culture_welcome_description);

        TextView introHeaderText = getView().findViewById(R.id.categoryIntroHeader);
        TextView introDescriptionText = getView().findViewById(R.id.categoryIntroDescription);

        if (black) {
            introHeaderText.setTextColor(getResources().getColor(R.color.black));
            introDescriptionText.setTextColor(getResources().getColor(R.color.black));
        }
        else {
            introHeaderText.setTextColor(getResources().getColor(R.color.white));
            introDescriptionText.setTextColor(getResources().getColor(R.color.white));
        }

        introHeaderText.setText(introHeader[m_Index]);
        introDescriptionText.setText(introDescription[m_Index]);
    }

    private void initializeRecyclerView() {
        m_CategoriesArrayList = new ArrayList<Categories>();

        for (int i = 0; i < m_ImageResource.length; i++) {
            Categories categories = new Categories(m_IndexSingleton.m_Category[i], m_ImageResource[i]);
            m_CategoriesArrayList.add(categories);
        }

        m_RecyclerView = getView().findViewById(R.id.categoryRecycler);
        m_RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        m_RecyclerView.setHasFixedSize(true);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), m_CategoriesArrayList);
        m_RecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
}