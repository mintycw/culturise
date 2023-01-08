package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityCategoryBinding;
import com.example.myapplication.databinding.ActivitySelectedBinding;


public class CategoryActivity extends AppCompatActivity {

    private ActivityCategoryBinding m_Binding;

    private String m_Culture[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        replaceFragment(new CategoryFragment());

        getSetData();
        setBarTitle();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        m_Binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());
    }

    private void getSetData() {
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            CategoryFragment.m_Index = getIntent().getIntExtra("index", 0);
        }
    }

    private void setBarTitle() {
        getSupportActionBar().setTitle(m_Culture[CategoryFragment.m_Index]);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.selectedFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}