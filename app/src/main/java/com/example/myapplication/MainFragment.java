package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding m_Binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        m_Binding = FragmentMainBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();

    }

    public void enterAsGuest() {
        Button guestButton = (Button) getView().findViewById(R.id.guestButton);

        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        enterAsGuest();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

}