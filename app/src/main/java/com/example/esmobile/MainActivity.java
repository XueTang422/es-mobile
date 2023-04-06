package com.example.esmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.esmobile.Fragments.HomeFragment;
import com.example.esmobile.Fragments.CalculatorFragment;
import com.example.esmobile.Fragments.ProfileFragment;
import com.example.esmobile.Fragments.SolarLearnFragment;
import com.example.esmobile.databinding.ActivityMainBinding;
import com.mikepenz.storyblok.Storyblok;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_solar_learn:
                    replaceFragment(new SolarLearnFragment());
                    break;
                case R.id.navigation_calculator:
                    replaceFragment(new CalculatorFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}