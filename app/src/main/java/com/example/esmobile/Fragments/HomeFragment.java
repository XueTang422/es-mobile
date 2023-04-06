package com.example.esmobile.Fragments;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.esmobile.Articles.Article;
import com.example.esmobile.Articles.ArticleAdapter;
import com.example.esmobile.ArticleDetailActivity;
import com.example.esmobile.R;
import com.example.esmobile.Articles.RecyclerItemClickListener;
import com.example.esmobile.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private int currentTab = 0;
    private ArrayList<ArrayList<Article>> listOfArticleList = new ArrayList<>();
    private TextView textView_explore, textView_local, textView_news, textView_saved;
    private ImageView imageView_explore, imageView_local, imageView_news, imageView_saved;

    private LinearLayout tab_explore;
    private LinearLayout tab_local;
    private LinearLayout tab_news;
    private LinearLayout tab_saved;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView home_rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView_explore=binding.tvExplore;
        textView_local=binding.tvLocal;
        textView_news=binding.tvNews;
        textView_saved=binding.tvSaved;

        imageView_explore=binding.ivExplore;
        imageView_local=binding.ivLocal;
        imageView_news=binding.ivNews;
        imageView_saved=binding.ivSaved;

        tab_explore=binding.homeTabExplore;
        tab_local=binding.homeTabLocal;
        tab_news=binding.homeTabNews;
        tab_saved=binding.homeTabSaved;

        home_rv=binding.rvArticleFragment;

        //Sample data for view to render
        Article a1 = new Article("CertainTeed solar panels", "Jane Doe",
                "03/31/2023", "article_cover_01", "es_logo",
                "CertainTeed is a large North American manufacturer of building materials, producing everything from drywall to roofing materials. Established in 1904 as the General Roofing Manufacturing Company, it is now a wholly owned subsidiary of Saint-Gobain SA, a 300 years old materials company based in Paris.",
                "01", "https://news.energysage.com/certainteed-solar-panels-complete-review/");

        Article a2 = new Article("Tesla solar panels", "Jane Doe",
                "03/30/2023", "article_cover_02", "es_logo",
                "Tesla entered the solar industry in 2016 when the Elon Musk-led company acquired SolarCity and began offering home battery storage and solar installations. Making the jump from electric vehicle manufacturer to a broad clean energy solutions provider, Tesla continues helping homeowners achieve energy independence.",
                "02", "https://news.energysage.com/tesla-solar-panels/");

        Article a3 = new Article("A complete guide to Mass Save’s massive heat pump rebates", "Jane Doe",
                "03/30/2023", "article_cover_03", "es_logo",
                "If you live in Massachusetts, there’s a good chance you’re eligible for a huge rebate on a heat pump—a super-efficient, all-in-one heating and cooling system for your home. (They’re also often called mini splits.) Here’s what you need to know.",
                "03", "https://news.energysage.com/mass-save-heat-pump-rebates/");

        Article a4 = new Article("LA Solar Group solar panels: the complete review", "Jane Doe",
                "03/29/2023", "article_cover_04", "es_logo",
                "LA Solar Group has been installing solar panels since they were founded in the Los Angeles area in 2011, with current installations spanning three states: California, Nevada, and Texas. During the past 12 years, they’ve installed over 25,000 systems and approximately 625,000 solar panels. "
                            ,"04","https://news.energysage.com/la-solar-panels-review/");

        Article a5 = new Article("What do California solar installers think about NEM 3? We asked them!", "Jane Doe",
                "03/10/2023", "article_cover_05", "es_logo",
                "Since the California Public Utilities Commission (CPUC) approved the Net Billing Tariff, also known as Net Metering 3 (NEM 3), in mid-December, the industry has primarily focused on how the new policy will affect solar shoppers in California (and for good reason): it reduces solar savings by more than 60% over 20 years. ",
                "05","https://news.energysage.com/what-california-solar-installers-think-about-nem-3/");


        Article a6 = new Article("How much does it cost to charge an electric vehicle? EV vs. gas fuel comparison", "Jane Doe",
                "03/15/2023", "article_cover_06", "es_logo",
                "In this article, we’ll explain how much you should expect to pay to charge your EV and how this compares to similar internal combustion engine (ICE) — AKA gas-powered — vehicles. We’ll also walk you through some of the significant factors that will impact the cost of charging your EV.",
                "06", "https://news.energysage.com/electric-vehicle-charging-cost-vs-gas/");

        Article a7 = new Article("5 Best solar companies in California", "EnergySage", "March 2023",
                "article_cover_07", "es_logo",
                "There are plenty of solar companies out there – check out this updated ranking for the top rated solar installers in California based on shopper preferences. Compare customer ratings, company tiers, and genuine customer feedback to see which installer is the best fit for your solar project.",
                "07", "https://www.energysage.com/local-data/solar-companies/ca/");

        Article a8 = new Article("Cost of electricity in California", "EnergySage", "04/02/2023",
                "article_cover_08", "es_logo",
                "On average, California residents spend about $210 per month on electricity. That adds up to $2,520 per year. That’s 8% higher than the national average electric bill of $2,324. The average electric rates in California cost 30 ¢/kilowatt-hour (kWh).",
                "08", "https://www.energysage.com/local-data/electricity-cost/ca/");

        ArrayList<Article> listOfExplore = new ArrayList<>();
        listOfExplore.add(a3);
        listOfExplore.add(a6);
        listOfExplore.add(a2);
        listOfExplore.add(a1);
        listOfExplore.add(a4);

        ArrayList<Article> listOfLocal = new ArrayList<>();

        listOfLocal.add(a7);
        listOfLocal.add(a5);
        listOfLocal.add(a8);
        listOfLocal.add(a4);

        ArrayList<Article> listOfNews = new ArrayList<>();

        listOfNews.add(a1);
        listOfNews.add(a2);
        listOfNews.add(a3);
        listOfNews.add(a4);
        listOfNews.add(a5);
        listOfNews.add(a6);

        ArrayList<Article> listOfSaved = new ArrayList<>();
        listOfSaved.add(a3);
        listOfSaved.add(a7);

        listOfArticleList.add(listOfExplore);
        listOfArticleList.add(listOfLocal);
        listOfArticleList.add(listOfNews);
        listOfArticleList.add(listOfSaved);

        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    public void run() {
                        setUpRecyclerView(0);
                    }
                }, 300);

        tab_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTab = 0;
                setUpRecyclerView(currentTab);
                changeBackToDefault();
                textView_explore.setTextColor(getResources().getColor(R.color.primary));
                imageView_explore.setVisibility(View.VISIBLE);
            }
        });

        tab_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTab = 1;
                setUpRecyclerView(currentTab);
                changeBackToDefault();
                textView_local.setTextColor(getResources().getColor(R.color.primary));
                imageView_local.setVisibility(View.VISIBLE);
            }
        });

        tab_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTab = 2;
                setUpRecyclerView(currentTab);
                changeBackToDefault();
                textView_news.setTextColor(getResources().getColor(R.color.primary));
                imageView_news.setVisibility(View.VISIBLE);
            }
        });

        tab_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTab = 3;
                setUpRecyclerView(currentTab);
                changeBackToDefault();
                textView_saved.setTextColor(getResources().getColor(R.color.primary));
                imageView_saved.setVisibility(View.VISIBLE);
            }
        });
        return root;
    }

    public void changeBackToDefault(){
        textView_explore.setTextColor(getResources().getColor(R.color.black));
        textView_local.setTextColor(getResources().getColor(R.color.black));
        textView_news.setTextColor(getResources().getColor(R.color.black));
        textView_saved.setTextColor(getResources().getColor(R.color.black));

        imageView_explore.setVisibility(View.INVISIBLE);
        imageView_local.setVisibility(View.INVISIBLE);
        imageView_news.setVisibility(View.INVISIBLE);
        imageView_saved.setVisibility(View.INVISIBLE);
    }

    public void setUpRecyclerView(int pos) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        ArrayList<Article> articleList = listOfArticleList.get(pos);
        ArticleAdapter articleAdapter = new ArticleAdapter(articleList, getContext());
        home_rv.setLayoutManager(linearLayoutManager);
        home_rv.setAdapter(articleAdapter);
        home_rv.setHasFixedSize(false);
        home_rv.setLayoutManager(layoutManager);
        home_rv.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),home_rv,new RecyclerItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                Article articleClicked = listOfArticleList.get(currentTab).get(position);
                String articleURL =articleClicked.getArticleUrl();
                Uri uri = Uri.parse(articleURL);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            @Override
            public void onLongItemClick(View view, int position){

            }
        }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}