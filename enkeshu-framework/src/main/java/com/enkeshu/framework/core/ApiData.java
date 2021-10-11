package com.enkeshu.framework.core;

import lombok.Data;

import java.io.Serializable;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/01/34
 **/
@Data
public class ApiData<T> implements Serializable {
    private String code;
    private String message;
    private T data;
}
