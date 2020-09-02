package com.enkeshu.spring.cloud.account.infra.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author enkeshu.zhou
 * @since 2020-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_account")
public class AccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    private String phone;

    private String email;

    private String username;

    private Integer gender;

    private Integer age;

    private String nickname;

    private LocalDateTime createTime;

    private LocalDateTime modifiedTime;

    private String createBy;

    private String modifiedBy;


}
