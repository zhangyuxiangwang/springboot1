package com.jrj.springboot;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitMQ8003_AppTests {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	
	@Test
	public void send(){
	// 上面的是指定交换器，把消息发送到了exchange.direct的交换器上，与绑定的queue的路由键“wangbin”
		//绑定的queue里面
	//	rabbitTemplate.convertAndSend("exchange.direct", "wangbin", "好样的");
	//rabbitmq默认的交换器是direct
		//rabbitTemplate.convertAndSend("jrj", "jrj  .....send1");
		
		/**
		 * exchange.fanout这种模式下的，不管指定路由键，都是会发送到所有的queue上面的，
		 * 和路由key没有什么关系
		 */
	//	rabbitTemplate.convertAndSend("exchange.fanout", "", "exchange.fanout .....send2");
		/**
		 * topic这个模式下，他会根据绑定的路由键来进行模糊匹配的
		 */
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("msg", "wangbin.topic");
		map.put("user","王斌");
		map.put("password", 111111);
		rabbitTemplate.convertAndSend("exchange.topic", "jrj.hhh", map);
	}
	
	@Test
	public void reservice(){
//		Message message = rabbitTemplate.receive("jrj.news");
//		System.out.println("----------------------");
//		System.out.println(message.getBody()+"---"+message.toString());
		Object convert = rabbitTemplate.receiveAndConvert("jrj");
		System.out.println(convert.toString());
	}
}
