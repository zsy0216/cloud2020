package org.example.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.common.CommonResult;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
public class CustomerBlockHandler {
	public static CommonResult<String> handlerException(BlockException exception) {
		return new CommonResult<>(2020, "自定义限流处理信息....CustomerBlockHandler");
	}
}

