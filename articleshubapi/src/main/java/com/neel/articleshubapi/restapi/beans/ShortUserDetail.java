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
 * Created by Neel Patel on 8/3/2017.
 * @author Neel Patel
 */

public class ShortUserDetail {
    private String userName;
    private String emailId;
    private String link;

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
     * @return link of the associated user resource
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link link of the associated user resource
     */
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ShortUserDetail:- username: "+getUserName();
    }

}
