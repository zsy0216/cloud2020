package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Long id;

	private Long userId;

	private Long productId;

	private Integer count;

	private BigDecimal money;

	/**
	 * 订单状态：0：创建中；1：已完结
	 */
	private Integer status;
}

