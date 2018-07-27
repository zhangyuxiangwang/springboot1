package com.jrj.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrj.springboot.GlobleConfig;
import com.jrj.springboot.MongoDBDaoIMpl;
import com.jrj.springboot.bean.User;

@RestController
@EnableConfigurationProperties(GlobleConfig.class)
public class MongoDBController {
	
	@Autowired
	private GlobleConfig globleConfig;
	@Autowired
	private MongoDBDaoIMpl mongo;
	
	@RequestMapping("/insertAll")
	public String insertAll(){
		List<User> list=new ArrayList<>();
		for (int i = 900; i < 1000; i++) {
			list.add(new User(i,"wang"+i,i));
		}
		mongo.insertList(list);
		return "success";
	}
	
	@RequestMapping("/insertOne")
	public String insertone(){
		User ser=new User(800,"zhao",90);
		mongo.insertOne(ser);
		return "success";
	}
	
	@RequestMapping("/queryAll")
	public List<User> queryAllList(){

		return mongo.queryList();
	}
	
	@RequestMapping("/queryAllName/{name}")
	public List<User> queryAll(@PathVariable String name){

		return mongo.queryLike(name);
	}

	
	@RequestMapping("/queryAll/{id}")
	public User queryAllId(@PathVariable int id){

		return mongo.queryOne(id);
	}
	
	@RequestMapping("/removeAll/{name}")
	public List<User> removeAll(@PathVariable String name){

		return mongo.removeAll(name);
	}
	
	@RequestMapping("/removeOne/{id}")
	public String removeOne(@PathVariable int id){

		return mongo.removeOne(id);
	}
	
	@RequestMapping("/update/{id}/{username}/{age}")
	public String update(User user){

		return mongo.update(user);
	}
	
	@RequestMapping("/page/{start}")
	public List<User> page(@PathVariable int start){

		PageRequest page=new PageRequest(1,start);
		return mongo.page(page);
	}
	
	@RequestMapping("/config")
	public GlobleConfig getGlobleConfig(){
		return globleConfig;
	}
}
