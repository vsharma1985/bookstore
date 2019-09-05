package com.java.assignment.bookStore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="author_id")  
	private int authorId;
	@Column(name="author_Name")  
	private String authorName;
	
	//private Set<com.java.assignment.bookStore.entity.Book> books;  
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="authors")  
	private List<Publication> publications;
	
	public List<Publication> getPublications() {
		return publications;
	}
	
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
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
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", publications=" + publications + "]";
	}
	
//    public Set<com.java.assignment.bookStore.entity.Book> getBooks()  
//    {  
//        return books;  
//    }  
//    public void setBooks(Set<com.java.assignment.bookStore.entity.Book> books)  
//    {  
//        this.books = books;  
//    }  
    
	
}
