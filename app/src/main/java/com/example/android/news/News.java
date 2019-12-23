package com.example.android.news;

public class News {
    private String title;
    private String section;
    private String author;
    private String datePublished;
    private String url;

     public News(String title, String section,String author,String datePublished,String url){
         this.title=title;
         this.section=section;
         this.author=author;
         this.datePublished=datePublished;
         this.url=url;
     }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getUrl() {
        return url;
    }
}
