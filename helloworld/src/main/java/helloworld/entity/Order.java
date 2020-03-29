package helloworld.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order",schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = -2343243243242432341L;
	
	@Id
	@Column(name = "order_id")
	private BigInteger orderId;
	
	@Column(name = "order_detail")
	private String orderDetail;
	
	@Column(name = "customer_id", insertable = true, updatable = true)
	private BigInteger customerId;
	
	@Column(name = "price_amount")
	private BigInteger price;
	
}
