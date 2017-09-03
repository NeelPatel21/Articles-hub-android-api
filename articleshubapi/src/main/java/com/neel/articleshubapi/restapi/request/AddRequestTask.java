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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**this class provides functionalities to make http request on restful webservice.
 * thia class is advanced version of 'RequestTask'.
 * additionally this class can be able to make any http request WITH BODY.
 * it provides functionality to parse POJO objects to Json as well as
   Http Json response in POJO objects.<br><br>
 * following snapshot of code can be used to update article having id '1'<br>
 * <pre>
 * {@code
        article.setAuthor("username");
        article.setTitle("android test");
        article.setArticleId(1);
        article.getContent().add("android update");
        AddRequestTask<String,ArticleDetail> rt6=new AddRequestTask<String, ArticleDetail>(String.class,
                article, HttpMethod.PUT, HeaderTools.CONTENT_TYPE_JSON,
                HeaderTools.makeAuth("402881825d691eaa015d693baadf0000"));
        rt6.execute(BASE_URL+"/article/1");
   }
 * </pre>
 * <br><br>
 * if the response is in form of plan text then the generic type must be String.<br>
 * following snapshot of code can be used to login user.<br>
 * <pre>
 * {@code
        UserDetail login =new UserDetail();
        login.setUserName("username");
        login.setPass("pass");
        AddRequestTask<String,UserDetail> rt4=new AddRequestTask<String, UserDetail>(String.class,
                login, HttpMethod.POST, HeaderTools.CONTENT_TYPE_JSON, HeaderTools.ACCEPT_TEXT);
        rt4.execute(BASE_URL+"/authentication/username");
        String token = rt4.getObj());
   }
 * </pre>
 * <br><br>
 * Created by Neel Patel on 24-07-2017.
 * @author Neel Patel
 * @see com.neel.articleshubapi.restapi.request.RequestTask
 * @see com.neel.articleshubapi.restapi.request.HeaderTools
 * @see android.os.AsyncTask
 * @version 1.0.0
 */

public class AddRequestTask<T,R> extends AsyncTask<String,Void,T> {

    private Class<T> type;
    private Map<String,String> headers=new HashMap<>();
    private HttpMethod meth;
    private R requestObj;

    public AddRequestTask(Class<T> type, R requestObj, HttpMethod meth,
                          Entry<String,String> ... header) {
        this.type=type;
        this.meth=meth;
        this.requestObj=requestObj;
        for(Entry<String,String> i:header){
            headers.put(i.getKey(),i.getValue());
        }
    }

    public AddRequestTask(Class<T> type, R requestObj, Entry<String,String> ... header) {
        this(type, requestObj, HttpMethod.GET, header);
    }

    @Override
    protected T doInBackground(String... params) {
        try {
            return new RequestHandler().getResource(type, params[0], meth, requestObj, headers);
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

    public T getObj(){
        try{
            return get();
        }catch(Exception ex){
            Log.e("RequestTask","doInBackground: "+ex.getMessage(),ex);
        }
        return null;
    }
}
