package com.tcmap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.tcmap.entity.Job;
import com.tcmap.entity.User;
import com.tcmap.mapper.JobMapper;
import com.tcmap.mgservies.UserServies;

@RestController
public class TestController {
	
	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private UserServies userServies;
	
    @RequestMapping(value="/test",method=RequestMethod.GET)
	public List<Job> getLove() {
    	List<Job> jobs = jobMapper.getJobs();
    	
		return jobs;
	}
    @RequestMapping(value="/test1",method=RequestMethod.GET)
	public Integer addLove() {
    	ArrayList<Job> list = new ArrayList<>();
		list.add(new Job("asdf","qwer"));
		list.add(new Job("asdf11","qwer11"));
		list.add(new Job("asdf22","qwer22"));
		int addJobs = jobMapper.addJobs(list);
		return addJobs;
	}
    @RequestMapping(value="/testmg",method=RequestMethod.GET)
	public List<User> getUsers() {
    	List<User> users = userServies.getUsers();
		return users;
	}
    @RequestMapping(value="/testmq",method=RequestMethod.GET)
    public void testMQ() throws JMSException {
//    	ActiveMQ的链接工厂
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//    	创建链接
    	Connection createConnection = connectionFactory.createConnection();
//    	启动链接
    	createConnection.start();
//    	创建session会话  参数一  是否在事务中处理  参数二 应答模式
    	Session session = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//    	创建目标
    	Destination createQueue = session.createQueue("testMQ");
//    	创建生产者
    	MessageProducer createProducer = session.createProducer(createQueue);
//    	创建消息
    	for(int i = 0;i < 100;i++) {
    		TextMessage createTextMessage = session.createTextMessage("test:"+i);
    		createProducer.send(createTextMessage);
    	}
    	createConnection.close();
    }
}
