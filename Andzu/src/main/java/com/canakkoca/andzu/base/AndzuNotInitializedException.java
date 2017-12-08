package com.canakkoca.andzu.base;

/**
 * Created by can.akkoca on 12/8/2017.
 */

public class AndzuNotInitializedException extends RuntimeException {

    public AndzuNotInitializedException () {

    }

    public AndzuNotInitializedException(String message){
        super(message);
    }


    public AndzuNotInitializedException (Throwable cause) {
        super (cause);
    }

    public AndzuNotInitializedException (String message, Throwable cause) {
        super (message, cause);
    }
}
