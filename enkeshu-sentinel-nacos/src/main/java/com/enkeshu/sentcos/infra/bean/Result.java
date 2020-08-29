package com.enkeshu.sentcos.infra.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this("00000", "success", data);
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
