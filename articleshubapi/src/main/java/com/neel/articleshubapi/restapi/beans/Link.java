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

/**
 * Created by Neel Patel on 24-07-2017.
 * @author Neel Patel
 * @version 1.0.0
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
