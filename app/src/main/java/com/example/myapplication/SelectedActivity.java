package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SelectedActivity extends AppCompatActivity {

    private String m_Culture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("culture")) {
            m_Culture = getIntent().getStringExtra("culture");
        }
    }

    private void setData() {
        getSupportActionBar().setTitle(m_Culture);
    }
}