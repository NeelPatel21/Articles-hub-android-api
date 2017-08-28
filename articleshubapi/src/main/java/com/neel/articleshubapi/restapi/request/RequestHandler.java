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

package com.neel.articleshubapi.restapi.request;

import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Map.*;

/**
 * Created by Neel Patel on 24-07-2017.
 */

public class RequestHandler{

    public <T,R> T getResource(Class<T> type, String url, HttpMethod meth,R requestObj,
                             Map<String,String> header){
        Log.i("RequestHandler","Request: "+url+", Method: "+meth+", Class: "+type.getName());
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            HttpEntity<R> request;
//            if(requestObj != null)
            HttpHeaders httpHeaders =new HttpHeaders();
            for(Entry<String,String> e:header.entrySet())
                httpHeaders.add(e.getKey(),e.getValue());
            request = new HttpEntity<>(requestObj,httpHeaders);
//            else
//                request = new HttpEntity(null);


//            Log.i("test2",request.toString());
            HttpEntity<T> response;
            response = restTemplate.exchange(url,meth,request,type);
            return response.hasBody()?response.getBody():null;
//            return restTemplate.getForObject(url,type,header);
        } catch (Exception e) {
            Log.e("RequestHandler", "getResource: "+e.getMessage(), e);
//            e.printStackTrace();
//            System.out.println("vjvbjbjbjb jvbjbjbjb "+url);
        }
        return null;
    }

    public <T> T getResource(Class<T> type, String url, HttpMethod meth,
                             Map<String,String> header){
        return getResource(type, url, meth, null, header);
    }

    public <T> T getResource(Class<T> type, String url, HttpMethod meth){
        return getResource(type, url, meth, Collections.<String, String>emptyMap());
    }

    public <T> T getResource(Class<T> type, String url){
        return getResource(type, url, HttpMethod.GET);
    }

}
