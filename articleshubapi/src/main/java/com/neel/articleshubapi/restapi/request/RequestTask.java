package com.neel.articleshubapi.restapi.request;

import android.os.AsyncTask;
import android.util.Log;


/**
 * Created by Neel Patel on 24-07-2017.
 */

public class RequestTask<T> extends AsyncTask<String,Void,T> {

    private Class<T> type;

    public RequestTask(Class<T> type) {
        this.type=type;
    }

    @Override
    protected T doInBackground(String... params) {
        try {
            return new RequestHandler().getResource(type, params[0]);
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
