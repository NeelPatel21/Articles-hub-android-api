/*
 * The MIT License
 *
 *  Copyright 2017 Neel Patel.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.neel.articleshubapi.restapi.beans;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neel Patel on 26-07-2017.
 */

public class CommentDetail {
    private long commentId;
    private long articleId;
    private String userName;
    private String content;
    private String date;
    private String time;
    private List<Link> links=new ArrayList<>();

    /**
     * @return comment id
     */
    public long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId comment id
     */
    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    /**
     * @return id of the associated article
     */
    public long getArticleId() {
        return articleId;
    }

    /**
     * @param articleId id of associated article
     */
    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    /**
     * @return username of the user who makes comment
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName username of the user who makes comment
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return content of the comment
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content content of the comment
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * this method returns links related to this object.
     * @return list of links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * @return comment date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date comment date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return comment time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time comment time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * this method returns Link object having name specified from
     the list returned by the {@code getLinks} method.
     * @param name name of the link
     * @return object of link having name specified. null otherwise.
     */
    public Link getLink(String name){
        try{
            for(Link l:getLinks())
                if(l.getName().equals(name))
                    return l;
        }catch(Exception ex){
            Log.e("CommentDetail", "getLink: "+ex.getMessage(),ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "CommentDetail:- comment_id: "+getCommentId()+", article_id: "+getArticleId();
    }
}
