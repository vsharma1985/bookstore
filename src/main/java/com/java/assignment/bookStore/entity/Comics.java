package com.java.assignment.bookStore.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Comics")
public class Comics extends Publication {

	private String comicHero;

	public String getComicHero() {
		return comicHero;
	}

	public void setComicHero(String comicHero) {
		this.comicHero = comicHero;
	}

	
}
