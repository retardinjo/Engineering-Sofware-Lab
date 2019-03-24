package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderProduct  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date dateTime;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id2", nullable=false)
	private Order order;

	public OrderProduct() {
		super();
	}

	public OrderProduct(int id, Date dateTime, Product product, Order order) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.product = product;
		this.order = order;
	}

	public OrderProduct(Date dateTime, Product product, Order order) {
		super();
		this.dateTime = dateTime;
		this.product = product;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", dateTime=" + dateTime + ", product=" + product + ", order=" + order + "]";
	}
	
	
}
