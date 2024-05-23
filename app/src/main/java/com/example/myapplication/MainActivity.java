package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

/**
 * The main entry point of the application.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding m_Binding;

    /**
     * Called when the activity is starting.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using data binding
        m_Binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());
    }
}
