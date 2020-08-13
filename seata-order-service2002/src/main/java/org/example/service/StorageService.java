package org.example.service;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
public interface StorageService {

	/**
	 * 扣减库存
	 *
	 * @param productId productId
	 * @param count     count
	 */
	void decrease(Long productId, Integer count);
}
