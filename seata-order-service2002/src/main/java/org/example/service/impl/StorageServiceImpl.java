package org.example.service.impl;

import org.example.dao.StorageDao;
import org.example.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Service
public class StorageServiceImpl implements StorageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

	@Resource
	private StorageDao storageDao;

	@Override
	public void decrease(Long productId, Integer count) {
		LOGGER.info("------->storage-service中扣减库存开始");
		storageDao.decrease(productId, count);
		LOGGER.info("------->storage-service中扣减库存结束");
	}
}
