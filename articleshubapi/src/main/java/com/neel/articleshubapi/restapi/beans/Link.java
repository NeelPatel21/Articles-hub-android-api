package com.neel.articleshubapi.restapi.beans;

/**
 * Created by Neel Patel on 24-07-2017.
 */

public class Link {
    private String name;
    private String url;

    public Link(){}

    /**
     * @param name name of the link
     * @param url url
     */
    public Link(String name,String url){
        this.name=name;
        this.url=url;
    }

    /**
     * @return name of the link
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name of the link
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Link:- name: "+getName()+", link: "+getUrl();
    }
}
