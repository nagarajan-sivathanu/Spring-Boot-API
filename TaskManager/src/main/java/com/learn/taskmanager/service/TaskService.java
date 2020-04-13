package com.learn.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.taskmanager.dao.TaskDao;
import com.learn.taskmanager.pojo.Task;
 

@Service
public class TaskService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private TaskDao taskDao;
	
	public List<Task> getAllTasks(){
		log.info("Inside TaskService --> getAllTasks Method");
		List<Task> tasks = new ArrayList<>();
		taskDao.findAll().forEach(tasks::add);
		return tasks;	
	}
	public void createTask(Task task) {
		log.info("Inside TaskService --> createTask Method"); 
		taskDao.save(task);
	}
	public void updateTask(Task task) {
		log.info("Inside TaskService --> updateTask Method");
		taskDao.save(task);
	}
}
