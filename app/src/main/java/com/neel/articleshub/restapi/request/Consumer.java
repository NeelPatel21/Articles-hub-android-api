package com.neel.articleshub.restapi.request;

/**
 * Created by Neel Patel on 24-07-2017.
 */

public interface Consumer<T>{
    void accept(T o);
}
