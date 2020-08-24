package com.example.kanishkaranu.newsshare;

import java.util.List;

public class News {
    private  String status;
    private String totalResults;
    private List<Articles> articles;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status= status;
    }
    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults= totalResults;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    }

