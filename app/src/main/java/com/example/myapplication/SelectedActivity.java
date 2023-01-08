package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SelectedActivity extends AppCompatActivity {

    private String m_Culture[];

    public static int m_CategoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);
        getSetData();
    }

    private void getSetData() {
        m_Culture = getResources().getStringArray(R.array.culture_names);

        if (getIntent().hasExtra("index")) {
            m_CategoryIndex = getIntent().getIntExtra("index", 0);
            String title = m_Culture[CategoryFragment.m_Index] + " - " + CategoryFragment.m_CategoryText[m_CategoryIndex];
            getSupportActionBar().setTitle(title);
        }
    }
}