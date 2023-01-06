package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.databinding.FragmentSelectedBinding;

public class SelectedFragment extends Fragment {

    private FragmentSelectedBinding m_Binding;

    public static ImageView m_Background;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        m_Binding = FragmentSelectedBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

    public static void setBackground(@NonNull View view, int index) {
        m_Background = (ImageView) view.findViewById(R.id.selectedBackground);
        switch (index) {
            case 0:
                m_Background.setImageResource(R.drawable.china_background);
                break;
            case 1:
                m_Background.setImageResource(R.drawable.italy_background);
                break;
            case 2:
                m_Background.setImageResource(R.drawable.japan_background);
                break;
        }
    }
}