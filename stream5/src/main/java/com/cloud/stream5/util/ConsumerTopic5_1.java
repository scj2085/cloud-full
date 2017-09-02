package com.cloud.stream5.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 多重条件选择的订阅
 * 消息接收者
 * @author shichangjian
 *
 */
public class ConsumerTopic5_1 {
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 创建连接和频道
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 声明转发器
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		// 随机生成一个队列
		String queueName = channel.queueDeclare().getQueue();

		// 接收所有与6666相关的消息
		channel.queueBind(queueName, EXCHANGE_NAME, "*.6666");

		System.err.println(" 交换机：\t\t" + EXCHANGE_NAME + "\nrouting key:\t*.6666");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.err.println("从交换机：【" + EXCHANGE_NAME + "】以routing key: 【" + envelope.getRoutingKey() + "】\t 绑定的队列：【" + queueName + "】中取到消息：" + ":【" + message + "】");
			}
		};
		// 指定接收者，第二个参数为自动应答，（消息接收失败不会转发到其他接收者）
		channel.basicConsume(queueName, true, consumer);
	}
}
