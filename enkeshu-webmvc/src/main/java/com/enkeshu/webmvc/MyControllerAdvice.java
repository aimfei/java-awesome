package com.enkeshu.webmvc;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.core.codec.DecodingException;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.List;


/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/5/27
 **/
@Component
@RestControllerAdvice(basePackages = "com.enkeshu.webmvc")
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyControllerAdvice {


    @ExceptionHandler(DecodingException.class)
    public ApiData uploadDecodingException(DecodingException e) {
        //log.error("methodNotAllowedException {}", e.getMessage());
        return new ApiData("","参数错误");
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ApiData methodNotAllowedException(MethodNotAllowedException e) {
       // log.error("methodNotAllowedException {}", e.getMessage());
            return new ApiData("","方法不支持");
    }


    @ExceptionHandler(JsonParseException.class)
    public ApiData jsonParseException(JsonParseException e) {
        //log.error("methodNotAllowedException {}", e.getMessage());
            return new ApiData("","json错误");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiData methodArgumentNotValidException(MethodArgumentNotValidException e) {
       // log.error("methodArgumentNotValidException {}", e.getMessage());
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return new ApiData("","验证参数错误");
    }
}
