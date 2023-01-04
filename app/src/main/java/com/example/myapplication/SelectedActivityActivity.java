package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivitySelectedActivityBinding;


public class SelectedActivityActivity extends AppCompatActivity {

    private ActivitySelectedActivityBinding m_Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_Binding = ActivitySelectedActivityBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());
    }
}