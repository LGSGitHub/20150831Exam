package com.hand;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Inventory entity. @author MyEclipse Persistence Tools
 */

public class Inventory implements java.io.Serializable {

	// Fields

	private Integer inventoryId;
	private Store store;
	private Film film;
	private Timestamp lastUpdate;
	private Set rentals = new HashSet(0);

	// Constructors

	/** default constructor */
	public Inventory() {
	}

	/** minimal constructor */
	public Inventory(Store store, Film film, Timestamp lastUpdate) {
		this.store = store;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Inventory(Store store, Film film, Timestamp lastUpdate, Set rentals) {
		this.store = store;
		this.film = film;
		this.lastUpdate = lastUpdate;
		this.rentals = rentals;
	}

	// Property accessors

	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getRentals() {
		return this.rentals;
	}

	public void setRentals(Set rentals) {
		this.rentals = rentals;
	}

}