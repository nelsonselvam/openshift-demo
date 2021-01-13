package com.openshift.demo.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Response.
 */
@JsonInclude(Include.NON_NULL)
public class Response {

	/** The service message. */
	@JsonProperty("message")
	private ServiceMessage serviceMessage;

	/** The suggested book. */
	@JsonProperty("bookSuggestion")
	private Book suggestedBook;

	/**
	 * Gets the service message.
	 *
	 * @return the service message
	 */
	public ServiceMessage getServiceMessage() {
		return serviceMessage;
	}

	/**
	 * Sets the service message.
	 *
	 * @param serviceMessage the new service message
	 */
	public void setServiceMessage(ServiceMessage serviceMessage) {
		this.serviceMessage = serviceMessage;
	}

	/**
	 * Gets the suggested book.
	 *
	 * @return the suggested book
	 */
	public Book getSuggestedBook() {
		return suggestedBook;
	}

	/**
	 * Sets the suggested book.
	 *
	 * @param suggestedBook the new suggested book
	 */
	public void setSuggestedBook(Book suggestedBook) {
		this.suggestedBook = suggestedBook;
	}

}
