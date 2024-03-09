package com.rum.ksc_back.KSCException;

public enum ApiError {
    //操作失败
    Fail("0001","操作失败"),
    //用户不存在
    UserNotFound("0002","用户不存在"),
    //账号停用
    UserNotAllowed("0003","账号已停用"),
    //登录失败
    LoginFailed("0004","登录失败"),
    //账号活密码错误
    PasswordNotCreat("0005","账号或密码错误"),
    //缺少注册信息
    NeedMoreInfo("0006","注册信息缺失");
    private final String errorCode;
    private final String errorMessage;
    ApiError(String errorCode, String errorMessage) {
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

}
