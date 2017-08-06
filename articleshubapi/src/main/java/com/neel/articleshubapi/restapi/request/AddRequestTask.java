package com.neel.articleshubapi.restapi.request;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Created by Neel Patel on 24-07-2017.
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
