package helloworld.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import helloworld.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,BigInteger>{
	List<Customer> findAll();
}
