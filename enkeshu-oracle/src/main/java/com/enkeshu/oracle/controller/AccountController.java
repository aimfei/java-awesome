package com.enkeshu.oracle.controller;

import com.enkeshu.oracle.dao.AccountDAO;
import com.enkeshu.oracle.entity.Account;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Order;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    AccountDAO accountDAO;

    @GetMapping("/{id}/get")
    public Object get(@PathVariable("id") String id) {

        for (int i = 0; i < 1000; i++) {
            Account account = new Account();
            account.setId(UUID.randomUUID().toString().replace("-", ""));
            account.setName("张三" +i );
            account.setNickname("昵称" +i);
            accountDAO.save(account);
        }
        return 1;
    }

    @GetMapping("/list")
    public Object list() {

        PageRequest page = PageRequest.of(0, 10);

        return accountDAO.findAll(page);
    }
}
