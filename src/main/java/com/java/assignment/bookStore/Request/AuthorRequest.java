package com.java.assignment.bookStore.Request;

import java.util.List;

public class AuthorRequest {
	
	
	public AuthorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorRequest(int authorId, String authorName, List<PublicationRequest> publications) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.publications = publications;
	}

	private int authorId;
	
	private String authorName;
	
	private List<PublicationRequest> publications;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<PublicationRequest> getPublications() {
		return publications;
	}

	public void setPublications(List<PublicationRequest> publications) {
		this.publications = publications;
	}
}
