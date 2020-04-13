package com.learn.taskmanager.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.taskmanager.pojo.Task;
import com.learn.taskmanager.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	List<Task> tasks;
	@Autowired
	private TaskService taskService;
	
	@GetMapping(value = "/tasks")
	public ResponseEntity<List<Task>> getAllTasks() {
		log.info("Inside TaskController --> getAllTasks Method");
		tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@PostMapping(value="/tasks")
	public ResponseEntity<Task>  createTask(@RequestBody Task task) {
		log.info("Inside TaskController --> createTask Method");
		taskService.createTask(task);	
		return new ResponseEntity<>(task, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/tasks")
	public ResponseEntity<Task> updateTask(@RequestBody Task task) {
		log.info("Inside TaskController --> updateTask Method");
		taskService.updateTask(task);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
}
