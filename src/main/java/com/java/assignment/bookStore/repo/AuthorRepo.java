package com.java.assignment.bookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.assignment.bookStore.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

	Author findByAuthorName(String authorName);

	@Query(value ="\n" + 
			"SELECT AUTHOR_NAME\n" + 
			"FROM AUTHOR\n" + 
			"JOIN author_pub ON AUTHOR.AUTHOR_ID = author_pub.author_id\n" + 
			"JOIN PUBLICATION ON author_pub.author_id = PUBLICATION.pub_id where PUBLICATION.year =:yearVal && author_name=:authorName" ,nativeQuery=true)
	Iterable<Author> findByYearAndAuthorName(@Param("yearVal")int yearVal, @Param("authorName")String authorName);

	@Query(value ="\n" + 
			"SELECT AUTHOR_NAME\n" + 
			"FROM AUTHOR\n" + 
			"JOIN author_pub ON AUTHOR.AUTHOR_ID = author_pub.author_id\n" + 
			"JOIN PUBLICATION ON author_pub.author_id = PUBLICATION.pub_id where  AUTHOR.author_name=:authorName" ,nativeQuery=true)
	Iterable<Author> findNovelsByAuthor(String authorName);
	
	
	
	
	
}
