package com.rum.ksc_back.KSCException;

public class ApiException extends RuntimeException{
    String errorCode;
    String errorMessage;
    public ApiException(String errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    public ApiException(ApiError apiError){
        this.errorCode=apiError.getErrorCode();
        this.errorMessage=apiError.getErrorMessage();
    }
}
