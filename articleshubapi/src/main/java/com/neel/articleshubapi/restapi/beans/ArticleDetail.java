package com.neel.articleshubapi.restapi.beans;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Neel Patel on 24-07-2017.
 */

public class ArticleDetail {
    private long articleId;
    private String title;
    private String author;
    private String date;
    private List<String> content;
    private Set<String> tag;
    private List<Link> links = new ArrayList<>();

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

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<Link> getLinks() {
        return links;
    }

    public Set<String> getTag() {
        return tag;
    }

    public void setTag(Set<String> tag) {
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Link getLink(String name){
        try{
            for(Link l:getLinks())
                if(l.getName().equals(name))
                    return l;
        }catch(Exception ex){
            Log.e("ArticleDetail", "getLink: "+ex.getMessage(),ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ArticleDetail:- articleId: "+getArticleId()+", title: "+getTitle();
    }
}
