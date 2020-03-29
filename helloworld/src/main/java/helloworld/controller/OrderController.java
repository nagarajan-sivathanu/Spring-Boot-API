package helloworld.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import helloworld.entity.Order;
import helloworld.repository.OrderRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class OrderController {
	
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("orders/getAll")
	public ResponseEntity<List<Order>> getAllOrders() {
		logger.debug("Inside HelloWorldController --> getAllOrders() Method");		
		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("orders/saveAll")
	public ResponseEntity<List<Order>> saveAllOrders(@RequestBody List<Order> orders){
		logger.debug("Inside HelloWorldController --> saveAllOrders() Method");
		return new ResponseEntity<>(orderRepository.saveAll(orders),HttpStatus.OK);
	}
	
	@DeleteMapping("orders/delete")
	public ResponseEntity<Void> deleteOrders(@RequestBody Order order){
		logger.debug("Inside HelloWorldController --> deleteOrders() Method");
		orderRepository.delete(order);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
