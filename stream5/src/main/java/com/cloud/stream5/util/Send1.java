package com.cloud.stream5.util;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 生产消息，如果只启动此类，可以在rabbitmq插件中，hello队列中，git message，获得队列中的消息
 * @author shichangjian
 *
 */
public class Send1 {
	
	private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws IOException, TimeoutException{
        
    	//创建一个连接
        ConnectionFactory factory = new ConnectionFactory();
        
        //连接本地，如果需要指定到服务，需在这里指定IP
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
       
        //创建一个通道
        Channel channel = connection.createChannel();
       
        //申明通道发送消息的队列，把消息发送至消息队列‘hello’
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        //如果队列不存在则会创建一个队列 
        //消息内容为byte array,可以自己随意编码
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        
        System.err.println("Sent '" + message + "'");

        //消息发送完成后，关闭通道和连接
        channel.close();
        connection.close();
    }
}
