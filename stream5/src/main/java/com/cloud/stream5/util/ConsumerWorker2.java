package com.cloud.stream5.util;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 接收信息，
 * 
 * @author shichangjian
 *
 */
public class ConsumerWorker2 {
	
	// 定义一个接收消息队列
	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] argv) throws Exception {
		// 创建连接和通道
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		final Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();

		// 队列持久化，在RabbitMQ重启保证队列不会丢失
		boolean durable = true;
		channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
		System.err.println("接收信息的消息队列：" + TASK_QUEUE_NAME);

		// 只有在消费者空闲的时候会发送下一条信息，告诉RabbitMQ不要在同一时间给一个消费者超过一条消息，注意：如果中途增加消费者，此时的消息已经分配完闭，无法立即加入工作，即使有很多未完成的任务
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);

		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");

				System.err.println("从" + TASK_QUEUE_NAME + "消息队列中获取到【" + message + "】");
				try {
					doWork(message);
				} finally {
					System.out.println("完成！");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		// 这里auto=false表示代开应答机制,一旦RabbItMQ交付了一个信息给消费者，会马上从内存中移除这个信息。在这种情况下，如果杀死正在执行任务的某个工作者，我们会丢失它正在处理的信息。我们也会丢失已经转发给这个工作者且它还未执行的消息,当某个工作者（接收者）被杀死时，我们希望将任务传递给另一个工作者
		boolean autoAck = false;
		channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
	}

	/**
	 * 
	 * @Title: doWork @Description: TODO(模拟做任务，每个'.'耗时一秒) @param @param task
	 * 设定文件 @return void 返回类型 @throws
	 */
	private static void doWork(String task) {
		for (char ch : task.toCharArray()) {
			if (ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException _ignored) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
