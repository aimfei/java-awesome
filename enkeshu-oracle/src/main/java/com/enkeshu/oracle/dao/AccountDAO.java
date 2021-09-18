package com.enkeshu.oracle.dao;

import com.enkeshu.oracle.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**Ø
 * @author mukang
 */
public interface AccountDAO extends JpaRepository<Account,String> {
}
