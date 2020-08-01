package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
	private Integer code;
	private String msg;
	private T data;

	public CommonResult(Integer code, String msg) {
		this(code, msg, null);
	}
}
