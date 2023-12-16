package com.practice.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.quiz.model.RealQuiz;

@Repository
public interface RealQuizDao extends JpaRepository<RealQuiz, Integer>{
	
	
	

}
