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

import helloworld.entity.Customer;
import helloworld.repository.CustomerRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class CustomerController {

	private Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("greetings")
	public String getGreeting() {
		logger.debug("Inside HelloWorldController --> getGreeting() Method");
		return "Hello World!!!!!";
	}
	
	@GetMapping("customers/getAll")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		logger.debug("Inside HelloWorldController --> getAllCustomers() Method");		
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("customers/saveAll")
	public ResponseEntity<List<Customer>> saveAllCustomers(@RequestBody List<Customer> customers){
		logger.debug("Inside HelloWorldController --> saveAllCustomers() Method");
		return new ResponseEntity<>(customerRepository.saveAll(customers),HttpStatus.OK);
	}
	
	@DeleteMapping("customers/delete")
	public ResponseEntity<Void> deleteCustomers(@RequestBody Customer customer){
		logger.debug("Inside HellowWorldController --> deleteCustomers() Method");
		customerRepository.delete(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
