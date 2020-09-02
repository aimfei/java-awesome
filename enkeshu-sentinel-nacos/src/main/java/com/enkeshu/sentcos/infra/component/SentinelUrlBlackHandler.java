package com.enkeshu.sentcos.infra.component;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.enkeshu.sentcos.infra.bean.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SentinelUrlBlackHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        log.error("SentinelUrlBlackHandler URI={}", request.getRequestURI());
        Result result = Result.builder().code("000600").message("亲，业务太繁忙了，请您稍后再试").build();
        /*Map<String, Object> backMap = new HashMap<>();
        backMap.put("error", "sentinel error");
        if (e instanceof FlowException) {
            backMap.put("code", 100);
            backMap.put("msg", "限流-异常");
        } else if (e instanceof DegradeException) {
            backMap.put("code", 101);
            backMap.put("msg", "降级-异常");
        } else if (e instanceof ParamFlowException) {
            backMap.put("code", 102);
            backMap.put("msg", "热点-异常");
        } else if (e instanceof SystemBlockException) {
            backMap.put("code", 103);
            backMap.put("msg", "系统规则-异常");
        } else if (e instanceof AuthorityException) {
            backMap.put("code", 104);
            backMap.put("msg", "认证-异常");
        }*/
        response.setStatus(500);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));

    }
}
