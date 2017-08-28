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
import java.util.Set;

/**
 * Pojo class for detail about articles.
 * Created by Neel Patel on 24-07-2017.
 * @author Neel Patel
 */

public class ArticleDetail {
    private long articleId;
    private String title;
    private String author;
    private String date;
    private List<String> content;
    private Set<String> tag;
    private List<Link> links = new ArrayList<>();

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
     * @return content of the article as List
     */
    public List<String> getContent() {
        return content;
    }

    /**
     * @param content content of the article as list of string
     */
    public void setContent(List<String> content) {
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
     * @return tags of article as a set.
     */
    public Set<String> getTag() {
        return tag;
    }

    /**
     * @param tag set of tag.
     */
    public void setTag(Set<String> tag) {
        this.tag = tag;
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
            Log.e("ArticleDetail", "getLink: "+ex.getMessage(),ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ArticleDetail:- articleId: "+getArticleId()+", title: "+getTitle();
    }
}
