package com.tcmap.mapper;


import java.util.List;


import com.tcmap.entity.Job;

public interface JobMapper {
//  查询所有job
    public List<Job> getJobs();
//  批量插入job
    public int addJobs(List<Job> jobs);
} 
