package com.hand;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */

public class Country implements java.io.Serializable {

	// Fields

	private Short countryId;
	private String country;
	private Timestamp lastUpdate;
	private Set cities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** minimal constructor */
	public Country(String country, Timestamp lastUpdate) {
		this.country = country;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Country(String country, Timestamp lastUpdate, Set cities) {
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.cities = cities;
	}

	// Property accessors

	public Short getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

}