package com.learn.apachecamel.processor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.vo.Task;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DBAccessJDBCProcessor implements Processor {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	@Override
	public void process(Exchange exchange) throws Exception {
		log.debug("Inside DBAccessJDBCProcessor");
		List<Map<String, Object>> row = exchange.getIn().getBody(List.class);
		row.stream().map(c->{
			Task task = new Task();
			task.setTaskID((int)c.get("task_id"));
			task.setTaskName((String)c.get("task_nm"));
			task.setStartDate((LocalDate.parse(c.get("start_dt").toString(),formatter)));
			task.setEndDate((LocalDate.parse(c.get("end_dt").toString(),formatter)));
			task.setPriority((int)c.get("priority"));
			task.setStatus((String)c.get("status"));
			return task;
		}).forEach(System.out::println);
	}
}
