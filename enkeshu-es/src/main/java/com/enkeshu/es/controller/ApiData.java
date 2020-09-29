package com.enkeshu.es.controller;

import lombok.Data;

@Data
public class ApiData<T> {
    private String code;
    private String message;
    private T data;

    public ApiData() {
    }

    public ApiData(T data) {
        this.code = "00000";
        this.message = "success";
        this.data = data;
    }

    public ApiData(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
