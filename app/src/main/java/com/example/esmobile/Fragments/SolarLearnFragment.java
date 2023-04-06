package com.example.esmobile.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        CardView solarLearnSolar101CardView=binding.solarLearnSolar101CardView;
        CardView solarLearnBenefitsOfSolarCardView=binding.solarLearnBenefitsOfSolarCardView;
        CardView solarLearnShouldYouGoSolarCardView=binding.solarLearnShouldYouGoSolarCardView;
        CardView solarLearnHowToGoSolarCardView=binding.solarLearnHowToGoSolarCardView;

        CardView solarLearnStorage101CardView=binding.solarLearnStorage101CardView;
        CardView solarLearnBenefitsOfStorageCardView=binding.solarLearnBenefitsOfStorageCardView;
        CardView solarLearnShouldYouGetStorageCardView = binding.solarLearnShouldYouGetStorageCardView;
        CardView solarLearnHowToGetStorageCardView=binding.solarLearnHowToGetStorageCardView;

        ImageView solarLearnEnergysageImg = binding.solarLearnEnergysageImg;

        solarLearnEnergysageImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EnergySageSolarURL ="http://www.energysage.com/solar/";
                Uri uri = Uri.parse(EnergySageSolarURL);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        solarLearnSolar101CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), SolarLearnActivity.class);
                getActivity().startActivity(myIntent);
            }
        });
        return root;
    }
}