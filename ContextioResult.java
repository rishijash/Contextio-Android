package com.rishi.contextio_library;

/**
 * Created by rishi jash on 1/5/16.
*/
 
public interface ContextioResult<T> {
    public void onTaskComplete(T result);
}
