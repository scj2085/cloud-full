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
 * 消费者，绑定指定的交换机下所有的队列，把信息输出到控制台
 * @author shichangjian
 *
 */
public class ConsumerConsole3 {

	 //定义转发器
    private static final String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //申明交换机名称和类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //创建一个非持久的、唯一的且自动删除的队列  
        String queueName = channel.queueDeclare().getQueue();
        //为转发器指定队列，设置binding  
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                    AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                   }
        };
        //指定接收者，第二个参数为自动应答，（消息接收失败不会转发到其他接收者）
        channel.basicConsume(queueName, true, consumer);
    }
}
