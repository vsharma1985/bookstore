package com.java.assignment.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignment.bookStore.Request.AuthorRequest;
import com.java.assignment.bookStore.entity.Author;
import com.java.assignment.bookStore.service.AuthorService;


@RestController
@RequestMapping(path = "/author")
public class AuthorController {

	@Autowired
	private AuthorService authorservice;
	
	@RequestMapping(value ="/hello",method=RequestMethod.GET)
	public String hello() {
		return "Welcome to author Controller";
	}
	
	@RequestMapping(value ="/",method=RequestMethod.POST)
	public void create(@RequestBody AuthorRequest author) {
		
		authorservice.create(author);
	}
	
	@RequestMapping(value ="/{year}/{authorName}",method=RequestMethod.GET)
	public Iterable<Author> getPublicationByYearAndAuthor(@PathVariable("year") String year,@PathVariable("authorName") String authorName) {
		return authorservice.findByYearAndAuthorName(year,authorName);
	}
	
	@RequestMapping(value ="/{authorName}",method=RequestMethod.GET)
	public Iterable<Author> getNovelsByAuthor(@PathVariable("gener") String gener,@PathVariable("authorName") String authorName) {
		return authorservice.findNovelsByAuthor(authorName);
	}
	
	
	@RequestMapping(value="/{authorName}",method=RequestMethod.DELETE)
    public void deleteAuthorByName(@PathVariable("authorName") String authorName) {
		authorservice.deleteAuthor(authorName);
    }
	
	
}
