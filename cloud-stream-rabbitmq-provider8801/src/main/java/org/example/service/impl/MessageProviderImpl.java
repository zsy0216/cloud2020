package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author shuaiyin.zhang
 * @description @EnableBinding(Source.class): 定义消息的推送管道
 * @date 2020/08/11
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
	/**
	 * 消息发送管道
	 */
	@Resource
	private MessageChannel output;

	@Override
	public String send() {
		String serial = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(serial).build());
		log.info("serial: {}", serial);
		return serial;
	}
}
