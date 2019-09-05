package com.java.assignment.bookStore.Request;

import java.util.List;

import com.java.assignment.bookStore.entity.Author;

public class PublicationRequest {

	private int pubId;  
	private String name; 
	private int year;
	private List<Author> authors;
	
	public PublicationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPubId() {
		return pubId;
	}
	public void setPubId(int pubId) {
		this.pubId = pubId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
