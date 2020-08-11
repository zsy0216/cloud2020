package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/11
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {
	@Value("${server.port}")
	private String serverPort;

	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		log.info("消费者 1 号，接受到消息：{}, port: {}", message.getPayload(), serverPort);
	}
}
