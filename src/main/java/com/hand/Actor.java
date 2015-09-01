package com.hand;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Actor entity. @author MyEclipse Persistence Tools
 */

public class Actor implements java.io.Serializable {

	// Fields

	private Short actorId;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;
	private Set filmActors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Actor() {
	}

	/** minimal constructor */
	public Actor(String firstName, String lastName, Timestamp lastUpdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Actor(String firstName, String lastName, Timestamp lastUpdate,
			Set filmActors) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
		this.filmActors = filmActors;
	}

	// Property accessors

	public Short getActorId() {
		return this.actorId;
	}

	public void setActorId(Short actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set filmActors) {
		this.filmActors = filmActors;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
				+ lastUpdate + ", filmActors=" + filmActors + "]";
	}

}