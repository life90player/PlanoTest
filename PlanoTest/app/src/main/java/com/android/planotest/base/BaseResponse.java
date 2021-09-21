package com.android.planotest.base;


public class BaseResponse<T> {
    private T data;//业务数据（包含业务层错误）
    private boolean state;//是否成功
    private String message;//返回消息

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return state;
    }

    public void setSuccess(boolean success) {
        this.state = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}