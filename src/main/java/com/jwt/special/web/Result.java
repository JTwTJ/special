package com.jwt.special.web;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangwentao
 * @date 2018/12/26 0026 下午 3:16
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 176176456118643813L;
    public T result;
    public String error;
    public String errorMessage;

    public Result(T result, String error) {
        this.result = result;
        this.error = error;
    }

    public Result(T result, String error, String errorMessage) {
        this.result = result;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public Result() {
    }

    public static <T> Result<T> ok(T result) {
        return new Result<T>(result, null);
    }

    public static <T> Result<T> fail(String error) {
        return new Result<T>(null, error);
    }

    public static <T> Result<T> fail(String error, String errorMessage) {
        return new Result<T>(null, error, errorMessage);
    }

    public static <T> Result<T> fail(T t, String error) {
        return new Result<T>(t, error);
    }

    public boolean isOk() {
        return (getError() == null);
    }
}
