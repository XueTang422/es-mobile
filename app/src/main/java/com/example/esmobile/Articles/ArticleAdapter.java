package com.example.esmobile.Articles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esmobile.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.Viewholder>{


    private final ArrayList<Article> articleList;
    private final Context context;

    public ArticleAdapter(ArrayList<Article> articleList, Context context){
        this.articleList=articleList;
        this.context=context;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_card_view,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Article article = articleList.get(position);
        Context context = holder.image_view_article_cover.getContext();
        String articleCoverId = article.getArticleCoverId();
        int coverId = context.getResources().getIdentifier(articleCoverId, "drawable", context.getPackageName());
        holder.image_view_article_cover.setImageResource(coverId);
        String articleOrganizationId = article.getArticleOrganizationId();
        int organizationId = context.getResources().getIdentifier(articleOrganizationId, "drawable", context.getPackageName());
        holder.image_view_article_organization.setImageResource(organizationId);
        holder.article_author.setText(article.getAuthor());
        holder.article_date.setText(article.getPublishDate());
        holder.article_abstract.setText(article.getArticleAbstract());
        holder.article_title.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        private ImageView image_view_article_cover, image_view_article_organization;
        private TextView article_title, article_author, article_date, article_abstract;
        public Viewholder(@NonNull View view){
            super(view);
            image_view_article_cover=view.findViewById(R.id.article_cover);
            image_view_article_organization=view.findViewById(R.id.article_organization);
            article_title=view.findViewById(R.id.article_name);
            article_author=view.findViewById(R.id.author_name);
            article_abstract=view.findViewById(R.id.article_abstract);
            article_date=view.findViewById(R.id.publish_date);
        }
    }
}
