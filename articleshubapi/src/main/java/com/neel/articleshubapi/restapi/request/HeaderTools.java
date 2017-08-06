package com.neel.articleshubapi.restapi.request;

import java.util.Map.Entry;

/**
 * Created by Neel Patel on 8/3/2017.
 */

public class HeaderTools {
    private HeaderTools(){}

    public static final Entry<String,String>
            CONTENT_TYPE_JSON=new EntryImp("Content-Type","application/json"),
            CONTENT_TYPE_XML=new EntryImp("Content-Type","application/xml"),
            ACCEPT_JSON=new EntryImp("Accept","application/json"),
            ACCEPT_XML=new EntryImp("Accept","application/xml"),
            ACCEPT_TEXT=new EntryImp("Accept","text/plain");

    public static Entry<String,String> makeAuth(String token){
        return new EntryImp("Authorization","token "+token);
    }

    public static class EntryImp implements Entry<String,String>{

        private String key;
        private String value;

        public EntryImp(String key,String value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            return null;
        }
    }
}
