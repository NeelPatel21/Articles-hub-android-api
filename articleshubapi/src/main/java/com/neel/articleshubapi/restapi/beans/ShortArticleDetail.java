package com.neel.articleshubapi.restapi.beans;

import javax.xml.XMLConstants.*;
/**
 * Created by Neel Patel on 8/3/2017.
 */

public class ShortArticleDetail {
    private long articleId;
    private String title;
    private String author;
    private String date;
    private String link;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ShortArticleDetail:- articleId: "+getArticleId()+", title: "+getTitle();
    }
}
