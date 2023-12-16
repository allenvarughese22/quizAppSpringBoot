package com.practice.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.quiz.dao.QuestionDao;
import com.practice.quiz.model.Question;

@Service
public class QuizService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity <List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK) ;
	}
	
	

	public ResponseEntity <List<Question>> findByCategory(String category) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK) ;
	}



	public ResponseEntity <String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		
		questionDao.save(question);
		return new ResponseEntity<>("Succceesssss",HttpStatus.OK) ;
	}

	
	}


