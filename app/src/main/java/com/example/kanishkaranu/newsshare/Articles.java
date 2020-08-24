package com.example.kanishkaranu.newsshare;

public class Articles {
   // private  String source;
    private  String author;
    private  String title;
    private String description;
    private  String url;
    private String urlToImage;
    private String publishedAt;

    private String content;

    public Articles( String author, String title,String url, String description, String urlToImage, String publishedAt, String content) {
        this.title=title;
        this.author=author;
        this.url=url;
        this.description=description;
        this.urlToImage=urlToImage;
        this.publishedAt=publishedAt;
        this.content=content;
    }




    public  String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public  String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public  String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public  String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }
    public String getUrlToImage()
    {
        return urlToImage;
    }
    public void setUrlToImage(String urlToImage)
    {
        this.urlToImage=urlToImage;
    }
    public  String getPublishedAt()
    {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt)
    {
        this.publishedAt = publishedAt;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }

    public String getName() {
        return null;
    }
    public String getId(){
        return null;
    }
}
