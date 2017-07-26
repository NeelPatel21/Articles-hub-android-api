package com.neel.articleshubapi.restapi.beans;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neel Patel on 26-07-2017.
 */

public class UserDetail {
    private String userName;
    private String info;
    private String emailId;
    private String pass;
    private List<Link> links=new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
        return "UserDetail:- username: "+getUserName();
    }
}
