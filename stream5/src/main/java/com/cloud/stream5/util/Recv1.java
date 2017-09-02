package com.cloud.stream5.util;
import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Recv1 {
	
	private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{
       
    	//创建一个连接
        ConnectionFactory factory = new ConnectionFactory();
       
        //连接本地，如果需要指定到服务，需在这里指定IP
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        
        //创建一个通道
        Channel channel = connection.createChannel();
        
        //申明接收消息的队列，与发送消息队列"hello"对应
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.err.println("消息接收的队列是：" + QUEUE_NAME);
        
        Consumer consumer = new DefaultConsumer(channel){
            //重写DefaultConsumer中handleDelivery方法，在方法中获取消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, 
                    AMQP.BasicProperties properties, byte[] body) throws IOException{
                String message = new String(body, "UTF-8");
                System.err.println("从 " + QUEUE_NAME + "队列中接收到消息：'" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true,consumer);
    }
}
