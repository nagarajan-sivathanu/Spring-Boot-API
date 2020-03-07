package helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("orders/getAll")
	public ResponseEntity<List<Order>> getAllOrders() {
		System.out.println("Inside HelloWorldController --> getAllOrders() Method");		
		return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("orders/saveAll")
	public ResponseEntity<List<Order>> saveAllOrders(@RequestBody List<Order> orders){
		System.out.println("Inside HelloWorldController --> saveAllOrders() Method");
		return new ResponseEntity<>(orderRepository.saveAll(orders),HttpStatus.OK);
	}
}
