/**
 * 
 */
package com.bimal.model;

import java.sql.Date;

/**
 * @author bimalthapa
 *
 */
public class InboxModel {
	
	private String date;
	private String sender;
	private String receiver;
	private String message;
	
	/**
	 Default Constructor
	 **/
	public InboxModel() {
		this.date = "";
		this.sender = "";
		this.receiver = "";
		this.message = "";
	}
	
	/**
	 * @param date
	 * @param sender
	 * @param receiver
	 * @param message
	 */
	public InboxModel(String date, String sender, String receiver, String message) {
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}