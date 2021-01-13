package com.openshift.demo.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Book {

	/** The book name. */
	@JsonProperty("bookName")
	private String bookName;

	/** The author. */
	@JsonProperty("author(s)")
	private String authors;

	/** The genre. */
	@JsonIgnore
	@JsonProperty("genre")
	private String genre;

	/** The book id. */
	@JsonInclude(Include.NON_DEFAULT)
	@JsonProperty("bookId")
	private int bookId;

	/** The book label. */
	@JsonProperty("bookMessage")
	private String bookLabel;

	/**
	 * Gets the book name.
	 *
	 * @return the book name
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * Sets the book name.
	 *
	 * @param bookName the new book name
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * Gets the authors.
	 *
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Sets the authors.
	 *
	 * @param authors the new authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the genre.
	 *
	 * @param genre the new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the book id.
	 *
	 * @return the book id
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * Sets the book id.
	 *
	 * @param bookId the new book id
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * Gets the book label.
	 *
	 * @return the book label
	 */
	public String getBookLabel() {
		return bookLabel;
	}

	/**
	 * Sets the book label.
	 *
	 * @param bookLabel the new book label
	 */
	public void setBookLabel(String bookLabel) {
		this.bookLabel = bookLabel;
	}
}
