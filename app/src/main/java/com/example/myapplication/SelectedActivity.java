package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class SelectedActivity extends AppCompatActivity {

    private AppManager m_AppManager;

    private int m_CultureIndex;
    private int m_CategoryIndex;
    private String m_Culture[];
    private String m_Category[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        replaceFragment(new SelectedFragment());
        getSetData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getSetData() {
        m_AppManager = AppManager.getInstance();
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            m_AppManager.setCategoryIndex(getIntent().getIntExtra("index", 0));
        }
        m_CultureIndex = m_AppManager.returnCultureIndex();
        m_CategoryIndex = m_AppManager.returnCategoryIndex();
        m_Category = m_AppManager.returnCategory();

        String title = m_Culture[m_CultureIndex] + " - " + m_Category[m_CategoryIndex];
        getSupportActionBar().setTitle(title);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.selectedFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}