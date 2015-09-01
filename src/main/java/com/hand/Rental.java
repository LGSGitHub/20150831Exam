package com.hand;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Rental entity. @author MyEclipse Persistence Tools
 */

public class Rental implements java.io.Serializable {

	// Fields

	private Integer rentalId;
	private Staff staff;
	private Customer customer;
	private Inventory inventory;
	private Timestamp rentalDate;
	private Timestamp returnDate;
	private Timestamp lastUpdate;
	private Set payments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rental() {
	}

	/** minimal constructor */
	public Rental(Staff staff, Customer customer, Inventory inventory,
			Timestamp rentalDate, Timestamp lastUpdate) {
		this.staff = staff;
		this.customer = customer;
		this.inventory = inventory;
		this.rentalDate = rentalDate;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Rental(Staff staff, Customer customer, Inventory inventory,
			Timestamp rentalDate, Timestamp returnDate, Timestamp lastUpdate,
			Set payments) {
		this.staff = staff;
		this.customer = customer;
		this.inventory = inventory;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.lastUpdate = lastUpdate;
		this.payments = payments;
	}

	// Property accessors

	public Integer getRentalId() {
		return this.rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Timestamp getRentalDate() {
		return this.rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Timestamp getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

}