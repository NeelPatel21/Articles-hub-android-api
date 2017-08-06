package com.neel.articleshubapi.restapi.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neel Patel on 8/3/2017.
 */

public class TagDetail {
    private String tagName;
    private List<Link> links=new ArrayList<>();

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Link> getLinks() {
        return links;
    }
}
