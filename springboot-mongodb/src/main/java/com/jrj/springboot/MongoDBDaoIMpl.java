package com.jrj.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jrj.springboot.bean.User;
import com.mongodb.WriteResult;

@Repository
public class MongoDBDaoIMpl {

	@Autowired
	private MongoTemplate mongo;
	/**
	 * 把user的集合放到mongo里面
	 * @param list
	 * @return
	 */
	public String insertList(List<User> list){
		mongo.insertAll(list);
		return "success";
	}
	/**
	 * 插入单个元素
	 * @param user
	 * @return
	 */
	public String insertOne(User user){
		mongo.insert(user);
		return "success";
	}
	/**
	 * 查询所有的值
	 * @return
	 */
	public List<User> queryList(){
		return mongo.findAll(User.class);
	}
	/**
	 * 查询单个值
	 * @param id 
	 * @return
	 */
	public User queryOne(int id){
		Query query=new Query(Criteria.where("id").is(id));
		return mongo.findOne(query, User.class);
	}
	/**
	 * 按照name值来模糊匹配
	 * @param name
	 * @return
	 */
	public List<User> queryLike(String name){
		Query query=new Query(Criteria.where("username").regex("^"+name));
		return mongo.find(query, User.class);
		
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<User> removeAll(String name){
		Query query=new Query(Criteria.where("username").regex("^"+name));
		return mongo.findAllAndRemove(query, User.class);
	}
	/**
	 * 删除满足条件的
	 * @param age
	 * @return
	 */
	public String removeOne(int age){
		Query query=new Query(Criteria.where("age").gt(age));
		WriteResult result = mongo.remove(query, User.class);
		return result.toString();
	}
	
	public String update(User user){
		Query query=new Query(Criteria.where("id").is(user.getId()));
		Update update = Update.update("username", user.getUsername()).set("age", user.getAge());
		mongo.updateMulti(query, update, User.class);
		return "修改成功";
	}
	
	public List<User> page(PageRequest page) {
		Query query=new Query();
		return mongo.find(query.with(page), User.class);
	}
}
