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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class SolarLearnActivity extends AppCompatActivity {
    private Storyblok storyblok;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_learn);
        // Initialize the Storyblok client with access token
        storyblok = Storyblok.init("Sts2HrLaU9Gyd3bdwZbj5wtt");
        TextView JsonObj = findViewById(R.id.JsonObj);
        TextView teaser =findViewById(R.id.teaser);
        TextView slug= findViewById(R.id.slug);
        TextView content = findViewById(R.id.content);
        TextView content2 = findViewById(R.id.content2);
        TextView content3 = findViewById(R.id.content3);
        TextView content4 = findViewById(R.id.content4);
        TextView content5 = findViewById(R.id.content5);
        TextView content6 = findViewById(R.id.content6);
        TextView content7 = findViewById(R.id.content7);
        TextView content8 = findViewById(R.id.content8);
        TextView content9 = findViewById(R.id.content9);
        TextView content10 = findViewById(R.id.content10);

        // Fetch and display an article with the slug "articles/my-first-article"
        storyblok.getStory("articles/solar-101", new Storyblok.SuccessCallback<Story>() {
            @Override
            public void onResponse(@android.support.annotation.Nullable @Nullable Result<Story> result) {
                Story story = result.getResult();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JsonObj.setText(story.getName());
                            teaser.setText(story.getPublishedAt().split("T")[0]);
                            slug.setText(story.getFullSlug());
                            content.setText(story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(1).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content2.setText(story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(2).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content3.setText(story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(3).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content4.setText("• "+story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(4).
                                    getJSONArray("content").getJSONObject(0).getJSONArray("content").getJSONObject(0).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content5.setText("• "+story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(4).
                                    getJSONArray("content").getJSONObject(1).getJSONArray("content").getJSONObject(0).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content6.setText("• "+story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(4).
                                    getJSONArray("content").getJSONObject(2).getJSONArray("content").getJSONObject(0).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content7.setText("• "+story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(4).
                                    getJSONArray("content").getJSONObject(3).getJSONArray("content").getJSONObject(0).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content8.setText(story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(5).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content9.setText(story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(6).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                            content10.setText(story.getContent().getJSONObject("text").getJSONArray("content").getJSONObject(7).
                                    getJSONArray("content").getJSONObject(0).get("text").toString());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        }, new Storyblok.ErrorCallback() {
            @Override
            public void onFailure(@android.support.annotation.Nullable @Nullable IOException exception, @android.support.annotation.Nullable @Nullable String response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JsonObj.setText("The Doc you are looking for is missing. Come back later!");
                    }
                });
            }
        });
    }
}
