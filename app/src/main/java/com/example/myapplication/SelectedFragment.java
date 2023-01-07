package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.databinding.FragmentSelectedBinding;

public class SelectedFragment extends Fragment {

    private FragmentSelectedBinding m_Binding;
    private SelectedActivity m_SelectedActivity;

    public static ImageView m_Background;

    public static int m_Index;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        m_SelectedActivity = new SelectedActivity();

        m_Binding = FragmentSelectedBinding.inflate(inflater, container, false);
        return m_Binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_Background = view.findViewById(R.id.selectedBackground);
        setBackground();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        m_Binding = null;
    }

    private void setBackground() {
        switch (m_Index) {
            case 0:
                m_Background.setImageResource(R.drawable.china_background);
                setText(false);
                break;
            case 1:
                m_Background.setImageResource(R.drawable.italy_background);
                setText(true);
                break;
            case 2:
                m_Background.setImageResource(R.drawable.japan_background);
                setText(true);
                break;
        }
    }

    private void setText(boolean black) {
        String introHeader[] = getResources().getStringArray(R.array.culture_welcome_header);
        String introDescription[] = getResources().getStringArray(R.array.culture_welcome_description);

        TextView introHeaderText = getView().findViewById(R.id.selectedIntroHeader);
        TextView introDescriptionText = getView().findViewById(R.id.selectedIntroDescription);

        if (black) {
            introHeaderText.setTextColor(getResources().getColor(R.color.black));
            introDescriptionText.setTextColor(getResources().getColor(R.color.black));
        }
        else {
            introHeaderText.setTextColor(getResources().getColor(R.color.white));
            introDescriptionText.setTextColor(getResources().getColor(R.color.white));
        }

        introHeaderText.setText(introHeader[m_Index]);
        introDescriptionText.setText(introDescription[m_Index]);
    }
}