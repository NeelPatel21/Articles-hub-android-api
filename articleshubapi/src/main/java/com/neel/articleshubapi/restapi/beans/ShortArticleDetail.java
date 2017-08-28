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

    /**
     * @return Id of the article
     */
    public long getArticleId() {
        return articleId;
    }

    /**
     * @param articleId id of the article
     */
    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    /**
     * @return title of the article
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title title of the article
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String represents publish date of article
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date String represents publish date of article
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return username of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author username of the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return link of the associated article resource
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link link of the associated article resource
     */
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ShortArticleDetail:- articleId: "+getArticleId()+", title: "+getTitle();
    }
}
