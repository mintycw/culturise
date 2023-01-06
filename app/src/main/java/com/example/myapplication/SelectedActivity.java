package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class SelectedActivity extends AppCompatActivity {

    private String m_Culture[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new SelectedFragment());
//        getSetData();
    }

    private void getSetData() {
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            int index = getIntent().getIntExtra("index", 0);

            getSupportActionBar().setTitle(m_Culture[index]);
//            SelectedFragment.setBackground(SelectedFragment.m_Background.getRootView(), index);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.selectedFrameLayout, fragment);
        fragmentTransaction.commit();
    }
}