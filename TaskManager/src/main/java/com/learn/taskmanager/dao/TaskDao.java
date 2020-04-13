package com.learn.taskmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.taskmanager.pojo.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, String> {
	List<Task> findAll();
}

