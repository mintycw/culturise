package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityHomeBinding;

/**
 * Activity for displaying the home screen.
 */
public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding m_Binding;

    /**
     * Called when the activity is starting.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout and set it as the content view
        m_Binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(m_Binding.getRoot());

        // Replace the default fragment with the HomeFragment
        replaceFragment(new HomeFragment());
    }

    /**
     * Replaces the current fragment with the given fragment.
     *
     * @param fragment The fragment to replace the current fragment with.
     */
    private void replaceFragment(Fragment fragment) {
        // Get the FragmentManager and start a new FragmentTransaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the fragment container with the new fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);

        // Commit the transaction
        fragmentTransaction.commit();
    }
}
