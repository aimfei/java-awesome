package com.enkeshu.spring.cloud.account.api.v1;

import com.enkeshu.spring.cloud.account.infra.domain.AccountModel;
import com.enkeshu.spring.cloud.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account/v1")
@Api
public class AccountController {


    @Resource
    private AccountService accountService;

    @GetMapping("/{id}/get")
    @ApiOperation(value = "会员详情查询")
    public AccountModel get(@PathVariable("id") Long id) {
        return accountService.getById(id);
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody AccountModel model) {
        return accountService.save(model);
    }
}
