package com.example.esmobile.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.esmobile.MainActivity;
import com.example.esmobile.R;
import com.example.esmobile.SolarLearnActivity;
import com.example.esmobile.databinding.FragmentSolarLearnBinding;

public class SolarLearnFragment extends Fragment {
    private FragmentSolarLearnBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSolarLearnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView text = binding.solarLearnText;
        text.setText("Hello");
        Button btn = binding.solarLearnButton;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), SolarLearnActivity.class);
                getActivity().startActivity(myIntent);
            }
        });
        return root;
    }
}