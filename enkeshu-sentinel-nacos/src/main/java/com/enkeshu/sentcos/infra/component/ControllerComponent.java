package com.enkeshu.sentcos.infra.component;

import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.enkeshu.sentcos.infra.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerComponent {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        log.error("handleException==============");
        Tracer.trace(e);
        return new Result("000500", "网络异常,请稍后再试");
    }

    @ExceptionHandler(BlockException.class)
    @ResponseBody
    public Result handleBlockException(BlockException e) {
        log.error("BlockException==============");
        Tracer.trace(e);
        return new Result("000400", "业务系统繁忙，请您稍后再试");
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<Result> handler(SecurityException e) {
        Result result = new Result("000400", "业务系统繁忙，请您稍后再试");
        Tracer.trace(e);
        return new ResponseEntity<Result>(result, HttpStatus.OK);
    }
}
