package com.learn.taskmanager.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Column(name = "TASK_ID",insertable=false,updatable=false)
	private long taskID;
	
	@Id
	@Column(name = "TASK_NM",unique = true)
	private String taskName;
	
	@Column(name = "START_DT")
	private LocalDate startDate;
	
	@Column(name = "END_DT")
	private LocalDate endDate;
	
	@Column(name = "PRIORITY")
	private int priority;
	
	@Column(name = "STATUS")
	private String status;
}
