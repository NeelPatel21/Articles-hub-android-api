package com.neel.articleshubapi.restapi.request;

import android.text.LoginFilter;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Neel Patel on 24-07-2017.
 */

public class RequestHandler{
    public <T> T getResource(Class<T> type,String url){
        Log.i("RequestHandler","Request: "+url+", Class: "+type.getName());
        try {
            RestTemplate restTemplate = new RestTemplate();
            boolean add = restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(url,type);
        } catch (Exception e) {
            Log.e("RequestHandler", "getResource: "+e.getMessage(), e);
//            e.printStackTrace();
//            System.out.println("vjvbjbjbjb jvbjbjbjb "+url);
        }
        return null;
    }
}
