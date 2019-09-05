package com.java.assignment.bookStore.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.assignment.bookStore.Request.AuthorRequest;
import com.java.assignment.bookStore.entity.Author;
import com.java.assignment.bookStore.entity.Book;
import com.java.assignment.bookStore.entity.Publication;
import com.java.assignment.bookStore.exception.AuthorPublishException;
import com.java.assignment.bookStore.repo.AuthorRepo;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;
	static final Logger LOGGER = Logger.getLogger(AuthorService.class);
	
	public void create(AuthorRequest request) {
		
		if(null==request) {
			throw new AuthorPublishException("Enter the Valid Details ...");
		}
		Author author = new Author();
		author.setAuthorId(request.getAuthorId());
		author.setAuthorName(request.getAuthorName());
		
		List<Author> authlist = new ArrayList<>();
		authlist.add(author);
		
		Book pub = new Book();
		pub.setPubId(request.getPublications().get(0).getPubId());
		pub.setName(request.getPublications().get(0).getName());
		pub.setBookGenre("Novel");
		pub.setYear(request.getPublications().get(0).getYear());	
		pub.setAuthors(authlist);
		
		List<Publication> publist = new ArrayList<>();
		publist.add(pub);
		
		author.setPublications(publist);
		
		authorRepo.save(author);
		LOGGER.info("Author is saved successfully");
	}

	
	public void deleteAuthor(String authorName) {
		Author author = authorRepo.findByAuthorName(authorName);
		if(null==author) {
			LOGGER.info("Author does not exist , nothing to be deleted");
			throw new AuthorPublishException("Author Entity does not exist in Database ...");
		}
		authorRepo.delete(author);
		
	}


	public Iterable<Author> findByYearAndAuthorName(String year,String authorName) {
		int yearVal = Integer.parseInt(year);
		return  authorRepo.findByYearAndAuthorName(yearVal,authorName);
		
	}


	public Iterable<Author> findNovelsByAuthor(String authorName) {
		return  authorRepo.findNovelsByAuthor(authorName);
	}
	
}
