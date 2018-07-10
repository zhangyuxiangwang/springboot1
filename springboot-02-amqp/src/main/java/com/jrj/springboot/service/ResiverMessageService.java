package com.jrj.springboot.service;

import java.util.Map;
import java.util.Set;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResiverMessageService {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues="jrj")
	public void receive(Map<String,Object> map){
//		System.out.println("------");
//		System.out.println(message.getBody().toString());
//		
//		System.out.println(message.getMessageProperties());
//		rabbitTemplate.receiveAndConvert("jrj");
		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(map.get(string));
		}
	}

}
