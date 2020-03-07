package helloworld.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import helloworld.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,BigInteger>{
	List<Order> findAll();
}
