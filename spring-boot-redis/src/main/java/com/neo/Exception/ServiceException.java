package com.neo.Exception;

/**
 * Created by liuyingan on 20/5/16.
 */
public class ServiceException extends Exception {

    public ServiceException(){
        super();
    }

    //用详细信息指定一个异常
    public ServiceException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public ServiceException(String message, Throwable cause){
        super(message,cause);
    }


    //用指定的详细信息和原因构造一个新的异常
    public ServiceException(String message, int errorCode){
        super(message);
    }

    //用指定原因构造一个新的异常
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
