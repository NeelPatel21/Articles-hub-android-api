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

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**this class provides functionalities to make http request on restful webservice.
 * this class can be able to make any http request WITHOUT BODY.
 * see 'AddRequestTask' to make Http request with body.
 * it provides functionality to parse the Http Json response in POJO objects.<br><br>
 * following snapshot of code can be used to get article having id '1'<br>
 * <pre>
 * {@code
        RequestTask<ArticleDetail> rt=new RequestTask<>(ArticleDetail.class,CONTENT_TYPE_JSON);
        rt.execute(BASE_URL+"/article/"+2);
        ArticleDetail article=rt.getObj();
   }
 * </pre>
 * <br><br>
 * if the response is in form of Json array of particular entity then the
   generic type must be Array of the class.<br>
 * following snapshot of code can be used to get user information of all the users
   who liked article with id '1'.<br>
 * <pre>
 * {@code
        RequestTask<ShortUserDetail[]> rt2=
                    new RequestTask<>(ShortUserDetail[].class,CONTENT_TYPE_JSON);
        rt2.execute(BASE_URL+"/article/1/likes");
        ShortUserDetail[] ud=rt2.getObj();
   }
 * </pre>
 * <br><br>
 * 'HeaderTools' class can be used to make authentication header using token and can be
   used make request which requires authentication.
 * any class can be used in case of empty response.
 * following snapshot of code can be used to add like on article.<br>
 * <pre>
 * {@code
        RequestTask<String> rt5=new RequestTask<String>(String.class, HttpMethod.POST,
                HeaderTools.CONTENT_TYPE_JSON,
                HeaderTools.makeAuth("402881825d691eaa015d693baadf0000"));
        rt5.execute(BASE_URL+"/user/username/like/1");
   }
 * </pre>
 * <br><br>
 * Created by Neel Patel on 24-07-2017.
 * @author Neel Patel
 * @see com.neel.articleshubapi.restapi.request.AddRequestTask
 * @see com.neel.articleshubapi.restapi.request.HeaderTools
 * @see android.os.AsyncTask
 * @version 1.0.0
 */

public class RequestTask<T> extends AsyncTask<String,Void,T> {

    private Class<T> type;
    private Map<String,String> headers=new HashMap<>();
    private HttpMethod meth;
    private HttpStatus httpStatus;

    /**make a object with specified parameters.
     * @param type class object of expected return type.
     * @param meth http request method.
     * @param header http request header.
     */
    public RequestTask(Class<T> type, HttpMethod meth, Entry<String,String> ... header) {
        this.type=type;
        this.meth=meth;
        for(Entry<String,String> i:header){
            headers.put(i.getKey(),i.getValue());
        }
    }

    /**make a class with http get request without body with specified headers.
     * @param type class object of expected return type.
     * @param header http request headers.
     */
    public RequestTask(Class<T> type, Entry<String,String> ... header) {
        this(type, HttpMethod.GET, header);
    }

    @Override
    protected T doInBackground(String... params) {
        try {
            RequestHandler rh = new RequestHandler();
            T obj = rh.getResource(type, params[0], meth, headers);
            this.httpStatus=rh.getHttpStatus();
            return obj;
        }catch(Exception ex){
//            System.err.println("do in back");
//            ex.printStackTrace();
            Log.e("RequestTask", "doInBackground: "+ex.getMessage(),ex);
        }
        return null;
    }

//    @Override
//    protected void onPostExecute(T obj) {
//        try{
//            con.accept(obj);
//        }catch(Exception ex){
//            System.err.println("on post execute");
//            ex.printStackTrace();
//        }
//    }

    /**
     * this method simply return object return by 'get' method of this class.
     * additionally it will mask all exceptions & return null if exception
       occurs while calling get method.
     * @return object parsed from http response.
     */
    public T getObj(){
        try{
            return get();
        }catch(Exception ex){
            Log.e("RequestTask","doInBackground: "+ex.getMessage(),ex);
        }
        return null;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
