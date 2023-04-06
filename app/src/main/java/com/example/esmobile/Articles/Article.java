package com.example.esmobile.Articles;

public class Article {
    private String title, author, publishDate, articleCoverId, articleOrganizationId,
            articleAbstract, articleId, articleUrl;
    public Article(String title, String author, String publishDate, String articleCoverId,
                   String articleOrganizationId, String articleAbstract, String articleId, String articleUrl){
        this.title=title;
        this.author=author;
        this.publishDate=publishDate;
        this.articleCoverId=articleCoverId;
        this.articleOrganizationId=articleOrganizationId;
        this.articleAbstract=articleAbstract;
        this.articleId=articleId;
        this.articleUrl=articleUrl;
    }

    public String getArticleCoverId() {
        return articleCoverId;
    }
    public String getArticleOrganizationId(){
        return articleOrganizationId;
    }

    public String getAuthor(){
        return author;
    }

    public String getPublishDate(){
        return publishDate;
    }

    public String getTitle(){
        return title;
    }

    public String getArticleAbstract(){
        return articleAbstract;
    }
    public String getArticleId(){
        return articleId;
    }
    public String getArticleUrl(){
        return articleUrl;
    }
}
