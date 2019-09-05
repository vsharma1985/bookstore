package com.java.assignment.bookStore.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Magzine")
public class Magzine extends Publication {

	private String magzineType;

	public String getMagzineType() {
		return magzineType;
	}

	public void setMagzineType(String magzineType) {
		this.magzineType = magzineType;
	}
}
