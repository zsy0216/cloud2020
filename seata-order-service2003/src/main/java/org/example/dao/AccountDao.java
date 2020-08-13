package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Mapper
public interface AccountDao {

	/**
	 * 扣减账户余额
	 */
	void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

