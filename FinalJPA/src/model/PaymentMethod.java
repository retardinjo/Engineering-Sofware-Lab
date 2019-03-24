package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PaymentMethod")
public class PaymentMethod  implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String type;
	private String name;
	
	@OneToMany(mappedBy="paymentMethod")
	private Set<Order> order;
	
	public PaymentMethod() {
		super();
	}
	public PaymentMethod(int id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
	}
	public PaymentMethod(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
