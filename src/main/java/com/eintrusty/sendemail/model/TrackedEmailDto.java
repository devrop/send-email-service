package com.eintrusty.sendemail.model;

import java.util.Date;

public class TrackedEmailDto {

	
	private String id;
	
	private String from;
	private String to;
	
	private String passwordFrom;
	private String passwordTo;
	private String usernameFrom;
	
	private Date createdDate;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getPasswordFrom() {
		return passwordFrom;
	}
	public void setPasswordFrom(String passwordFrom) {
		this.passwordFrom = passwordFrom;
	}
	public String getPasswordTo() {
		return passwordTo;
	}
	public void setPasswordTo(String passwordTo) {
		this.passwordTo = passwordTo;
	}
	public String getUsernameFrom() {
		return usernameFrom;
	}
	public void setUsernameFrom(String usernameFrom) {
		this.usernameFrom = usernameFrom;
	}
	
	
}
