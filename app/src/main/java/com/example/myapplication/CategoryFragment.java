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

/**
 * Fragment to display categories based on the selected culture.
 */
public class CategoryFragment extends Fragment {

    private AppManager m_IndexSingleton;
    private FragmentCategoryBinding m_Binding;

    private ImageView m_Background;
    private int m_Index;
    private int[] m_ImageResource;
    private ArrayList<Categories> m_CategoriesArrayList;
    private RecyclerView m_RecyclerView;

    /**
     * Called to have the fragment instantiate its user interface view.
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        m_IndexSingleton = AppManager.getInstance();
        m_Index = m_IndexSingleton.returnCultureIndex();
        m_Binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();
    }

    /**
     * Called immediately after onCreateView() has returned, but before any saved state has been restored in to the view.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_Background = view.findViewById(R.id.categoryBackground);
        setCulture();
    }

    /**
     * Called when the fragment's view is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

    /**
     * Sets up the UI based on the selected culture.
     */
    private void setCulture() {
        // Determine background image and category data based on selected culture
        switch (m_Index) {
            case 0:
                // Set background image and category data for China
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
                // Set background image and category data for Italy
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
                // Set background image and category data for Japan
                m_Background.setImageResource(R.drawable.japan_background);
                m_ImageResource = new int[] {
                        R.drawable.happy_mango,
                        R.drawable.kazaguruma,
                        R.drawable.osozai,
                };
                m_IndexSingleton.m_Category = getResources().getStringArray(R.array.japan_activities);

                initializeRecyclerView();
                setText(true);
                break;
            case 3:
                // Set background image and category data for Turkey
                m_Background.setImageResource(R.drawable.turkey_background);
                m_ImageResource = new int[] {
                        R.drawable.ortam_bbq,
                        R.drawable.ilham,
                        R.drawable.forbest,
                        R.drawable.mevlana_moskee,
                };
                m_IndexSingleton.m_Category = getResources().getStringArray(R.array.turkey_activities);

                initializeRecyclerView();
                setText(true);
                break;
            case 4:
                // Set background image and category data for Spain
                m_Background.setImageResource(R.drawable.spain_background);
                m_ImageResource = new int[] {
                        R.drawable.lokanta_proeflokaal,
                        R.drawable.iberica_la_espanola,
                        R.drawable.una_paloma_blanca,
                };
                m_IndexSingleton.m_Category = getResources().getStringArray(R.array.spain_activities);

                initializeRecyclerView();
                setText(true);
                break;
        }
        initializeRecyclerView();
        setText(true);
    }

    /**
     * Sets the introductory text based on the selected culture.
     *
     * @param black Flag indicating if text color should be black or white.
     */
    private void setText(boolean black) {
        // Set introductory text based on selected culture
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

    /**
     * Initializes the RecyclerView with category items.
     */
    private void initializeRecyclerView() {
        // Create list of categories and populate RecyclerView with CategoryAdapter
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
