package com.cloud.stream5.util;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 多重条件选择的订阅
 * 消息发送类
 * 发送五条消息，路由键分别为 
	“kernel.info”, “cron.warning”, “auth.info”,”auth.critical”, “kernel.critical”
 * @author shichangjian
 *
 */
public class SenderTopic5 {
	
	//	交换器名称
	private static final String EXCHANGE_NAME = "topic_logs";
	// 队列名称
	private final static String TASK_QUEUE_NAME = "topic_queue";
	
	public static void main(String[] argv) throws IOException, TimeoutException {
		// 创建连接和频道
		ConnectionFactory factory = new ConnectionFactory();
		
		//连接本地，如果需要指定到服务，需在这里指定IP
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		
		//创建一个通道
		Channel channel = connection.createChannel();

		// 声明转发器和类型，消息由routingKey决定发送到哪个队列
		//1,fanout类型：绑定交换机ex_log下面的所有队列，
		//2,direct类型:绑定交换机ex_log下面的routing Key匹配的所有队列，转换器背后的路由算法：消息会被推送至绑定键（binging key）和发布消息发布的附带选择键（routing key）匹配的队列
		//3,topic主题类型：绑定交换机ex_log下面的以通配符 * # 匹配的所有队列
		//发往主题类型的转发器的消息不能随意的设置选择键（routing_key），必须是由点隔开的一系列的标识符组成。标识符可以是任何东西，但是一般都与消息的某些特性相关。一些合法的选择键的例子："stock.usd.nyse", "nyse.vmw","quick.orange.rabbit".你可以定义任何数量的标识符，上限为255个字节(32个字符)。
	    //绑定键和选择键的形式一样。主题类型的转发器背后的逻辑和直接类型的转发器很类似：一个附带特殊的选择键将会被转发到绑定键与之匹配的队列中。需要注意的是：关于绑定键有两种特殊的情况。
		// *可以匹配一个标识符。
		// #可以匹配0个或多个标识符
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");//主题类型的topic:基于多重条件进行路由选择

		String[] routing_keys = new String[] { "1111.4444", "2222.5555", "3333.4444", "3333.6666","1111.6666" };
		
		int i = 1;
		for (String routing_key : routing_keys) {
			String msg = "test msg,message num is " + i;
			i++;
			channel.basicPublish(EXCHANGE_NAME, routing_key, null, msg.getBytes());
			
			System.err.println("发送到交换机：【" + EXCHANGE_NAME + "】以routing key: 【" + routing_key + "】\t 绑定的队列中到消息：" + ":【" + msg + "】");
		}
		channel.close();
		connection.close();
	}

}
