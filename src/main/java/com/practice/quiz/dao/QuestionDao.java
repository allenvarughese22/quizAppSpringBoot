package com.practice.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	
	

	@Query(value = "select * from question q where q.category= :category order by rand() limit :numbOfQues", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numbOfQues);
	
//	@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numbOfQues", nativeQuery = true)
//	List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numbOfQues") int numbOfQues);


	List<Question> findByCategory(String category);

	

}
