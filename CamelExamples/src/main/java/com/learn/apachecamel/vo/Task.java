package com.learn.apachecamel.vo;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {	
	
	private long taskID;
	private String taskName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int priority;
	private String status;
}
