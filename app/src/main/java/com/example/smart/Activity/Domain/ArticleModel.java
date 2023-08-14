package com.example.smart.Activity.Domain;

public class ArticleModel {
    String articleName;
    String description;
    int image;


    public ArticleModel(String articleName, int image,String description) {
        this.articleName = articleName;
        this.image = image;
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public String getArticleName() {
        return articleName;
    }

    public int getImage() {
        return image;
    }
}