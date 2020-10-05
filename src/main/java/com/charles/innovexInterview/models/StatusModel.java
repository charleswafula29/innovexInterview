package com.charles.innovexInterview.models;

public class StatusModel {
    private int code;
    private String message;

    public StatusModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StatusModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
