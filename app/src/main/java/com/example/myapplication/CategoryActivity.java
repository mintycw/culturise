package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityCategoryBinding;

/**
 * Activity to display categories based on the selected culture.
 */
public class CategoryActivity extends AppCompatActivity {

    private ActivityCategoryBinding m_Binding;
    private AppManager m_IndexSingleton;

    private int m_Index;
    private String m_Culture[];

    /**
     * Called when the activity is starting.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Replace the default fragment with the CategoryFragment
        replaceFragment(new CategoryFragment());

        // Set up data and action bar
        getSetData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inflate the layout and set the content view
        m_Binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());
    }

    /**
     * Retrieves data about the selected culture and sets up the action bar title.
     */
    private void getSetData() {
        m_IndexSingleton = AppManager.getInstance();
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            m_IndexSingleton.setCultureIndex(getIntent().getIntExtra("index", 0));
        }
        m_Index = m_IndexSingleton.returnCultureIndex();
        getSupportActionBar().setTitle(m_Culture[m_Index]);
    }

    /**
     * Replaces the fragment in the activity layout with the provided fragment.
     *
     * @param fragment The fragment to be displayed.
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.categoryFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}
