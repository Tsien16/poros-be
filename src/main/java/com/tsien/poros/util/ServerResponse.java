package com.tsien.poros.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/24 0024 9:53
 * 注解 @JsonInclude(JsonInclude.Include.NON_NULL)，保证序列化Json的时候，如果是null对象，key也会消失
 * 注解 @JsonIgnore，使之不在序列化结果当中
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == HttpStatus.OK.value();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> ServerResponse<T> ok() {
        return new ServerResponse<>(HttpStatus.OK.value());
    }

    public static <T> ServerResponse<T> ok(String msg) {
        return new ServerResponse<>(HttpStatus.OK.value(), msg);
    }

    public static <T> ServerResponse<T> ok(T data) {
        return new ServerResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> ServerResponse<T> ok(String msg, T data) {
        return new ServerResponse<>(HttpStatus.OK.value(), msg, data);
    }

    public static <T> ServerResponse<T> error() {
        return new ServerResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static <T> ServerResponse<T> error(String errorMsg) {
        return new ServerResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMsg);
    }

    public static <T> ServerResponse<T> errorCodeMessage(int errorCode, String errorMsg) {
        return new ServerResponse<>(errorCode, errorMsg);
    }

    public static <T> ServerResponse<T> errorCodeMessage(int errorCode, String errorMsg, T data) {
        return new ServerResponse<>(errorCode, errorMsg, data);
    }

}