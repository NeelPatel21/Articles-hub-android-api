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
 * Created by Neel Patel on 8/3/2017.
 * @author Neel Patel
 * @version 1.0.0
 */

public class TagDetail {
    private String tagName;
    private List<Link> links=new ArrayList<>();

    /**
     * @return name of the tag
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName name of the tag
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * this method returns links related to this object.
     * @return list of links
     */
    public List<Link> getLinks() {
        return links;
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
            Log.e("TagDetail", "getLink: "+ex.getMessage(),ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "TagDetail:- username: "+getTagName();
    }
}
