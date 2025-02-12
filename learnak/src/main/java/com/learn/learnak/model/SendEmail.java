package com.learn.learnak.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sendemail")
public class SendEmail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String recipient;
    private String subject;
    private String message;
    
    
	public SendEmail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SendEmail(String recipient, String subject, String message) {
		super();
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
	}


	public String getRecipient() {
		return recipient;
	}


	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
