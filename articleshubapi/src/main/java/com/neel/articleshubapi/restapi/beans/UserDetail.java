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
 * @author Neel Patel
 * @version 1.0.0
 */

public class UserDetail {
    private String userName;
    private String info;
    private String emailId;
    private String pass;
    private List<Link> links=new ArrayList<>();

    /**
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return information about user
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info information about user
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return email id of user
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId email id of user
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * this method returns links related to this object.
     * @return list of links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * @return password
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass password
     */
    public void setPass(String pass) {
        this.pass = pass;
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
            Log.e("UserDetail", "getLink: "+ex.getMessage(),ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserDetail:- username: "+getUserName();
    }
}
