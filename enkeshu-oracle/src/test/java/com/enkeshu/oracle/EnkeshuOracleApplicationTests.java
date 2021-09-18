package com.enkeshu.oracle;

import com.enkeshu.oracle.dao.AccountDAO;
import com.enkeshu.oracle.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
@Slf4j
class EnkeshuOracleApplicationTests {

    @Resource
    AccountDAO accountDAO;

    @Test
    void contextLoads() {
    }

    @Test
    private void testSave(){
        log.info("333");
        Account account=new Account();
        account.setId(UUID.randomUUID().toString().replace("-",""));
        account.setName("张三");
        account.setNickname("32");
        accountDAO.save(account);
    }

}
