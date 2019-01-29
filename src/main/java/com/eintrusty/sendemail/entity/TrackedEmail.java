package com.eintrusty.sendemail.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tracked_email")
public class TrackedEmail {
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private String id;
	
	@Column(name="from")
	private String from;
	@Column(name="to")
	private String to;
	@Column(name="created_date")
	private Date createdDate;
	
	
	
	
	public TrackedEmail(String id, String from, String to, Date createdDate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.createdDate = createdDate;
	}
	
	public TrackedEmail(String from, String to, Date createdDate) {
		super();
		this.from = from;
		this.to = to;
		this.createdDate = createdDate;
	}

	public TrackedEmail() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	
	
	

}
