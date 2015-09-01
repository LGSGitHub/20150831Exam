package com.hand;

/**
 * FilmCategoryId entity. @author MyEclipse Persistence Tools
 */

public class FilmCategoryId implements java.io.Serializable {

	// Fields

	private Film film;
	private Category category;

	// Constructors

	/** default constructor */
	public FilmCategoryId() {
	}

	/** full constructor */
	public FilmCategoryId(Film film, Category category) {
		this.film = film;
		this.category = category;
	}

	// Property accessors

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmCategoryId))
			return false;
		FilmCategoryId castOther = (FilmCategoryId) other;

		return ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
				&& castOther.getFilm() != null && this.getFilm().equals(
				castOther.getFilm())))
				&& ((this.getCategory() == castOther.getCategory()) || (this
						.getCategory() != null
						&& castOther.getCategory() != null && this
						.getCategory().equals(castOther.getCategory())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		result = 37 * result
				+ (getCategory() == null ? 0 : this.getCategory().hashCode());
		return result;
	}

}