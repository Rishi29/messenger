package org.rishi.synapsys.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//this annotation tells JAX-B that this is the root which needs to be converted to XML
@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String Author;
	
	public Message(){}
	
	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created =new Date();
		Author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	

}
