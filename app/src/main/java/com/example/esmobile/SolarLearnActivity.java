package com.example.esmobile;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mikepenz.storyblok.*;
import com.mikepenz.storyblok.model.Result;
import com.mikepenz.storyblok.model.Story;

import org.json.JSONObject;

import java.io.IOException;


public class SolarLearnActivity extends AppCompatActivity {
    private Storyblok storyblok;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_learn);
        // Initialize the Storyblok client with access token
        storyblok = Storyblok.init("OwhfSHpIPuY4R3Oa6ULNDgtt");
        TextView JsonObj = findViewById(R.id.JsonObj);
        JsonObj.setText("Failed");
        // Fetch and display an article with the slug "articles/my-first-article"
        storyblok.getStory("articles/solar-101", new Storyblok.SuccessCallback<Story>() {
            @Override
            public void onResponse(@android.support.annotation.Nullable @Nullable Result<Story> result) {
                JSONObject Obj = result.getResult().getContent();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JsonObj.setText(Obj.toString());
                    }
                });
            }
        }, new Storyblok.ErrorCallback() {
            @Override
            public void onFailure(@android.support.annotation.Nullable @Nullable IOException exception, @android.support.annotation.Nullable @Nullable String response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JsonObj.setText("Failed");
                    }
                });
            }
        });
    }
}
