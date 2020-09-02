package com.enkeshu.spring.cloud.account.service.impl;

import com.enkeshu.spring.cloud.account.infra.domain.AccountModel;
import com.enkeshu.spring.cloud.account.infra.mapper.AccountMapper;
import com.enkeshu.spring.cloud.account.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lz
 * @since 2020-09-02
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountModel> implements AccountService {


}
