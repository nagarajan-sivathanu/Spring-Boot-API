package helloworld.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer",schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = -2343243243242432341L;
	
	@Id
	@Column(name = "customer_id")
	private BigInteger customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_age")
	private BigInteger customerAge;
	
	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")  
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Order> orders;

}
