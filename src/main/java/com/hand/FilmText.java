package com.hand;

/**
 * FilmText entity. @author MyEclipse Persistence Tools
 */

public class FilmText implements java.io.Serializable {

	// Fields

	private Short filmId;
	private String title;
	private String description;

	// Constructors

	/** default constructor */
	public FilmText() {
	}

	/** minimal constructor */
	public FilmText(String title) {
		this.title = title;
	}

	/** full constructor */
	public FilmText(String title, String description) {
		this.title = title;
		this.description = description;
	}

	// Property accessors

	public Short getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
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

}