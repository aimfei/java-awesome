package com.enkeshu.webflux;

import java.io.Serializable;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/5/27
 **/
public class ApiData implements Serializable {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiData() {

    }
}
