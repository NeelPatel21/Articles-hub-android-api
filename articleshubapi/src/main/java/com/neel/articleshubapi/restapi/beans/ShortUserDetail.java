package com.neel.articleshubapi.restapi.beans;

/**
 * Created by Neel Patel on 8/3/2017.
 */

public class ShortUserDetail {
    private String userName;
    private String emailId;
    private String link;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ShortUserDetail:- username: "+getUserName();
    }

}
