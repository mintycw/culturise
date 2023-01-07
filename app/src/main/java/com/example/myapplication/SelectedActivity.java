package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivitySelectedBinding;


public class SelectedActivity extends AppCompatActivity {

    private ActivitySelectedBinding m_Binding;

    private String m_Culture[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        replaceFragment(new SelectedFragment());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSetData();

        m_Binding = ActivitySelectedBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());
    }

    private void getSetData() {
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            SelectedFragment.m_Index = getIntent().getIntExtra("index", 0);
            getSupportActionBar().setTitle(m_Culture[SelectedFragment.m_Index]);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.selectedFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}