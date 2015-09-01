package com.hand;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Film entity. @author MyEclipse Persistence Tools
 */

public class Film implements java.io.Serializable {

	// Fields

	private Short filmId;
	private Language languageByOriginalLanguageId;
	private Language languageByLanguageId;
	private String title;
	private String description;
	private Date releaseYear;
	private Short rentalDuration;
	private Double rentalRate;
	private Short length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
	private Timestamp lastUpdate;
	private Set filmActors = new HashSet(0);
	private Set filmCategories = new HashSet(0);
	private Set inventories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Film() {
	}

	/** minimal constructor */
	public Film(Language languageByLanguageId, String title,
			Short rentalDuration, Double rentalRate, Double replacementCost,
			Timestamp lastUpdate) {
		this.languageByLanguageId = languageByLanguageId;
		this.title = title;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Film(Language languageByOriginalLanguageId,
			Language languageByLanguageId, String title, String description,
			Date releaseYear, Short rentalDuration, Double rentalRate,
			Short length, Double replacementCost, String rating,
			String specialFeatures, Timestamp lastUpdate, Set filmActors,
			Set filmCategories, Set inventories) {
		this.languageByOriginalLanguageId = languageByOriginalLanguageId;
		this.languageByLanguageId = languageByLanguageId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.lastUpdate = lastUpdate;
		this.filmActors = filmActors;
		this.filmCategories = filmCategories;
		this.inventories = inventories;
	}

	// Property accessors

	public Short getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	public Language getLanguageByOriginalLanguageId() {
		return this.languageByOriginalLanguageId;
	}

	public void setLanguageByOriginalLanguageId(
			Language languageByOriginalLanguageId) {
		this.languageByOriginalLanguageId = languageByOriginalLanguageId;
	}

	public Language getLanguageByLanguageId() {
		return this.languageByLanguageId;
	}

	public void setLanguageByLanguageId(Language languageByLanguageId) {
		this.languageByLanguageId = languageByLanguageId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Short getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(Short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Double getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Short getLength() {
		return this.length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
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

	public Set getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(Set filmCategories) {
		this.filmCategories = filmCategories;
	}

	public Set getInventories() {
		return this.inventories;
	}

	public void setInventories(Set inventories) {
		this.inventories = inventories;
	}

}