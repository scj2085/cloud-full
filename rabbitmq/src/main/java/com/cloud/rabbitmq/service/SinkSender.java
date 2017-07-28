package com.cloud.rabbitmq.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * 创建一个input消息通道作为输出通道的接口
 * @author shichangjian
 *
 */
public interface SinkSender {

	@Output(Sink.INPUT)
	MessageChannel output();
}
