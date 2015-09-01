package com.hand;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private Short storeId;
	private Staff staff;
	private Address address;
	private Timestamp lastUpdate;
	private Set inventories = new HashSet(0);
	private Set customers = new HashSet(0);
	private Set staffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** minimal constructor */
	public Store(Staff staff, Address address, Timestamp lastUpdate) {
		this.staff = staff;
		this.address = address;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Store(Staff staff, Address address, Timestamp lastUpdate,
			Set inventories, Set customers, Set staffs) {
		this.staff = staff;
		this.address = address;
		this.lastUpdate = lastUpdate;
		this.inventories = inventories;
		this.customers = customers;
		this.staffs = staffs;
	}

	// Property accessors

	public Short getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getInventories() {
		return this.inventories;
	}

	public void setInventories(Set inventories) {
		this.inventories = inventories;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	public Set getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set staffs) {
		this.staffs = staffs;
	}

}