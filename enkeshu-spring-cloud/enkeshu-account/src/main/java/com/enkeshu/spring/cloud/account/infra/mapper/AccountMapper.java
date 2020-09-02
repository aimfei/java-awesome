package com.enkeshu.spring.cloud.account.infra.mapper;

import com.enkeshu.spring.cloud.account.infra.domain.AccountModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author enkeshu.zhou
 * @since 2020-09-02
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountModel> {

}
