package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.Order;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Mapper
public interface OrderDao {
	/**
	 * 新建订单
	 *
	 * @param order order
	 */
	void create(Order order);

	/**
	 * 修改订单状态，从零改为1
	 *
	 * @param userId userId
	 * @param status status
	 */
	void update(@Param("userId") Long userId, @Param("status") Integer status);
}
