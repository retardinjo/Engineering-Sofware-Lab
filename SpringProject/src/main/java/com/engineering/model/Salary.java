package com.engineering.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;

import java.util.List;


@Entity
@Table(name = "SALARY_TABLE")
public class Salary implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SALARY_ID")
	private int salaryId;

	@Column(name="AMOUNT_OF_MONEY")
	private BigDecimal amountOfMoney;

	// bi-directional many-to-one association to Position
	@OneToMany(mappedBy="salary")
	@JsonBackReference
	private List<Position> positions;
	
	
	// CONSTRUCTORS, GETTERS and SETTERS

	public Salary() {
		super();
	}
	
	public Salary(int salaryId) {
		super();
		this.salaryId = salaryId;
	}
	
	public Salary(int salaryId, BigDecimal amountOfMoney) {
		super();
		this.salaryId = salaryId;
		this.amountOfMoney = amountOfMoney;
	}

	public int getSalaryId() {
		return this.salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	public BigDecimal getAmountOfMoney() {
		return this.amountOfMoney;
	}

	public void setAmountOfMoney(BigDecimal amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Position addPosition(Position position) {
		getPositions().add(position);
		position.setSalary(this);

		return position;
	}

	public Position removePosition(Position position) {
		getPositions().remove(position);
	    position.setSalary(null);

		return position;
	}
	
}
