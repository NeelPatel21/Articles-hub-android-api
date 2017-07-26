package com.neel.articleshubapi.restapi.beans;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neel Patel on 26-07-2017.
 */

public class CommentDetail {
    private long commentId;
    private long articleId;
    private String userName;
    private String Contant;
    private String date;
    private String time;
    private List<Link> links=new ArrayList<>();


    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContant() {
        return Contant;
    }

    public void setContant(String Contant) {
        this.Contant = Contant;
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
