package com.cloud.stream5.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息生产者，绑定指定的交换机下所有的队列
 * @author shichangjian
 *
 */
public class SenderFanout3 {
	
	//转发器名称
    private final static String EXCHANGE_NAME = "ex_log";  
    
    public static void main(String[] args) throws IOException, TimeoutException{  
        // 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        
        // 声明转发器和类型  
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout" );//fanout类型：绑定交换机ex_log下面的所有队列
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = sdf.format(new Date());  
        // 往转发器上发送消息  ,第一个参数为转发器的名称,如果存在routingKey（第二个参数），消息由routingKey决定发送到哪个队列
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());  

        System.err.println(" 生产的消息，[" +  message + "]进入交换机： '" + EXCHANGE_NAME + "'");  

        channel.close();  
        connection.close();  

    }  
}
