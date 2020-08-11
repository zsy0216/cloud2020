package org.example.controller;

import org.example.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/11
 */
@RestController
public class SendMessageController {
	@Resource
	private IMessageProvider messageProvider;

	@GetMapping(value = "/sendMessage")
	public String sendMessage() {
		return messageProvider.send();
	}
}
