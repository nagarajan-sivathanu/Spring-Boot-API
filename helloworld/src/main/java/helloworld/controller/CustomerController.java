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

import helloworld.entity.Customer;
import helloworld.repository.CustomerRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("greetings")
	public String getGreeting() {
		System.out.println("Inside HelloWorldController --> getGreeting() Method");
	return "Hello World!!!!!";
	}
	
	@GetMapping("customers/getAll")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		System.out.println("Inside HelloWorldController --> getAllCustomers() Method");		
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("customers/saveAll")
	public ResponseEntity<List<Customer>> saveAllCustomers(@RequestBody List<Customer> customers){
		System.out.println("Inside HelloWorldController --> saveAllCustomers() Method");
		return new ResponseEntity<>(customerRepository.saveAll(customers),HttpStatus.OK);
	}
}
