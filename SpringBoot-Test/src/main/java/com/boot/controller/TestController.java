package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.mgservies.UserServies;
import com.neo.entity.Job;
import com.neo.entity.User;
import com.neo.mapper.JobMapper;

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
    @RequestMapping(value="/testmg",method=RequestMethod.GET)
	public List<User> getUsers() {
    	List<User> users = userServies.getUsers();
		return users;
	}
}
