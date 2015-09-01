package com.hand;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Language entity. @author MyEclipse Persistence Tools
 */

public class Language implements java.io.Serializable {

	// Fields

	private Short languageId;
	private String name;
	private Timestamp lastUpdate;
	private Set filmsForOriginalLanguageId = new HashSet(0);
	private Set filmsForLanguageId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Language() {
	}

	/** minimal constructor */
	public Language(String name, Timestamp lastUpdate) {
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Language(String name, Timestamp lastUpdate,
			Set filmsForOriginalLanguageId, Set filmsForLanguageId) {
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
		this.filmsForLanguageId = filmsForLanguageId;
	}

	// Property accessors

	public Short getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Short languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getFilmsForOriginalLanguageId() {
		return this.filmsForOriginalLanguageId;
	}

	public void setFilmsForOriginalLanguageId(Set filmsForOriginalLanguageId) {
		this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
	}

	public Set getFilmsForLanguageId() {
		return this.filmsForLanguageId;
	}

	public void setFilmsForLanguageId(Set filmsForLanguageId) {
		this.filmsForLanguageId = filmsForLanguageId;
	}

}