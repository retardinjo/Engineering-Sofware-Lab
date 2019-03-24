package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private double totalSum;
		private Date dateTime;
		
		@ManyToOne
		@JoinColumn(name="paymentMethod", nullable=false)
		private PaymentMethod paymentMethod;
		
		@ManyToOne
		@JoinColumn(name="user", nullable=false)
		private User user;
		
		@OneToMany(mappedBy="order")
		private Set<OrderProduct> orderProduct;

		public Order() {
			super();
		}

		public Order(int id, double totalSum, Date dateTime, PaymentMethod paymentMethod, User user) {
			super();
			this.id = id;
			this.totalSum = totalSum;
			this.dateTime = dateTime;
			this.paymentMethod = paymentMethod;
			this.user = user;
		}

		public Order(double totalSum, Date dateTime, PaymentMethod paymentMethod, User user) {
			super();
			this.totalSum = totalSum;
			this.dateTime = dateTime;
			this.paymentMethod = paymentMethod;
			this.user = user;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getTotalSum() {
			return totalSum;
		}

		public void setTotalSum(double totalSum) {
			this.totalSum = totalSum;
		}

		public Date getDateTime() {
			return dateTime;
		}

		public void setDateTime(Date dateTime) {
			this.dateTime = dateTime;
		}

		public PaymentMethod getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(PaymentMethod paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		
		
}
