package com.cloud.stream5.util;
import java.util.Random;  
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息生产者，指定routing key 绑定队列，目的只对严重性日志error创建一个绑定，对info,error,warning创建一个绑定
 * @author shichangjian
 *
 */
public class SenderDirect4 {

	 //转发器名称
    private static final String EXCHANGE_NAME = "ex_logs_direct";  
    
    
    //几种安全级别日志
    private static final String[] SEVERITIES = { "info", "warning", "error" };  

    public static void main(String[] argv) throws java.io.IOException, TimeoutException{  
        
    	// 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        
        //连接本地，如果需要指定到服务，需在这里指定IP
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        
        //创建一个通道
        Channel channel = connection.createChannel();  
        
        // 声明转发器的类型  
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");//direct类型：指定routing key绑定队列  

        //发送6条消息  
        for (int i = 0; i < 6; i++){  
            String severity = getSeverity(); 
            System.err.println("routing key:是" + severity);
            
            String message = severity + "_log :" + UUID.randomUUID().toString();  
            // 发布消息至转发器，指定routing key  
            channel.basicPublish(EXCHANGE_NAME, severity, null, message  
                    .getBytes());
            int y = i + 1;
            System.err.println("发布第"+ y + "个消息：【" + message + "】至交换机：'" + EXCHANGE_NAME + "'");  
        }  

        channel.close();  
        connection.close();
    }
    
    /**
     * 随机产生一个日志类型
     * @return
     */
    private static String getSeverity() {  
        Random random = new Random();  
        int ranVal = random.nextInt(3);  
        return SEVERITIES[ranVal];  
    }
}
