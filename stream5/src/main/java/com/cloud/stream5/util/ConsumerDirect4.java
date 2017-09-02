
package com.cloud.stream5.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 消息消费者，指定routing key绑定队列，目的只对严重性日志error创建一个绑定，对info,error,warning创建一个绑定
 * @author shichangjian
 *
 */
public class ConsumerDirect4 {
	 //转发器名称
    private static final String EXCHANGE_NAME = "ex_logs_direct";  
    //几种安全级别日志
    private static final String[] SEVERITIES = { "info", "warning", "error" };  

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
       
        // 声明direct类型转发器  
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");  

        String queueName = channel.queueDeclare().getQueue();  
        String severity = getSeverity();  
        // 指定binding_key  
        channel.queueBind(queueName, EXCHANGE_NAME, severity);  
        System.err.println(" routing key: " + severity + " 绑定到：" + EXCHANGE_NAME + "交换机");  

//        Consumer consumer = new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope,
//                    AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    String message = new String(body, "UTF-8");
//                    System.err.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
//                   }
//        };
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                    AMQP.BasicProperties properties, byte[] body) throws IOException {

                    String path = this.getClass().getClassLoader().getResource("").getPath();
                    System.out.println(path);
                    File file = new File(path,"log.txt");
                    FileOutputStream out = new FileOutputStream(file,true);
                    out.write(body);
                    out.write("\r\n".getBytes());
                    out.flush();
                    out.close();
                   }
        };
        //指定接收者，第二个参数为自动应答，（消息接收失败不会转发到其他接收者）
        channel.basicConsume(queueName, true, consumer);
    }

    /**
     * 随机产生一个日志类型
     * @return
     */
    private static String getSeverity() {
         Random random = new Random();  
         int ranVal = random.nextInt(3);  
//         return SEVERITIES[ranVal];  
         return "error";  
    }
}
