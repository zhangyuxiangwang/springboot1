package com.jrj.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	
	@RequestMapping("/send")
	public String send(){
		Map<String, Object> map=new HashMap<>();
		map.put("send", "direct");
		map.put("key", 1111111);
		map.put("username", "王斌");
		
		rabbitTemplate.convertAndSend("exchange.direct", "jrj", map);
		return "success";
	}

}
