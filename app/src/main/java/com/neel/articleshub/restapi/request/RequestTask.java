package com.neel.articleshub.restapi.request;

import android.os.AsyncTask;


/**
 * Created by Neel Patel on 24-07-2017.
 */

public class RequestTask<T> extends AsyncTask<String,Void,T> {

    private Class<T> type;
    private Consumer<T> con;


    public RequestTask(Class<T> type,Consumer<T> con) {
        this.type=type;
        this.con=con;
    }

    @Override
    protected T doInBackground(String... params) {
        try {
            return new RequestHandler().getResource(type, params[0]);
        }catch(Exception ex){
            System.err.println("do in back");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(T obj) {
        try{
            con.accept(obj);
        }catch(Exception ex){
            System.err.println("on post execute");
            ex.printStackTrace();
        }
    }
}
