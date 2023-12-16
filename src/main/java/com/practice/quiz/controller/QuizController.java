package com.practice.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quiz.model.Question;
import com.practice.quiz.service.QuizService;

@RequestMapping("question")
@RestController
public class QuizController {
	
	@Autowired
	QuizService quizService;
		
	@GetMapping("question")
	public ResponseEntity <List<Question>>getAllQuestons()
	{
		return quizService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category)
	{
		return quizService.findByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		
		return quizService.addQuestion(question);
	}

}
