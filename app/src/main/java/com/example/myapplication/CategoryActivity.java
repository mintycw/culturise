package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityCategoryBinding;

public class CategoryActivity extends AppCompatActivity {

    private ActivityCategoryBinding m_Binding;
    private AppManager m_IndexSingleton;

    private int m_Index;
    private String m_Culture[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        replaceFragment(new CategoryFragment());

        getSetData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        m_Binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());
    }

    private void getSetData() {
        m_IndexSingleton = AppManager.getInstance();
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            m_IndexSingleton.setCultureIndex(getIntent().getIntExtra("index", 0));
        }
        m_Index = m_IndexSingleton.returnCultureIndex();
        getSupportActionBar().setTitle(m_Culture[m_Index]);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.categoryFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}