package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Mapper
public interface StorageDao {

	/**
	 * 扣减库存信息
	 *
	 * @param productId productId
	 * @param count     count
	 */
	void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
