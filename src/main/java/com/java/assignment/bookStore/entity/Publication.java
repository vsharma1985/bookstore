package com.java.assignment.bookStore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="publication")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		  name="publication_type", 
		  discriminatorType=DiscriminatorType.STRING
		  )
public class Publication {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="pub_id")
	private int pubId;  
	private String name; 
	private int year;
	
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="author_pub", joinColumns=@JoinColumn(name="pub_id"), inverseJoinColumns=@JoinColumn(name="author_id"))  
	private List<Author> authors;
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
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
	
	
	
	
	
	
}
