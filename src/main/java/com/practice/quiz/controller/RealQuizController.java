package com.practice.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quiz.model.Question;
import com.practice.quiz.model.QuestionWrapper;
import com.practice.quiz.service.RealQuizService;

@RestController
@RequestMapping("quiz")
public class RealQuizController {
	
	@Autowired
	RealQuizService  realQuizService; 
	
	@PostMapping("create")
	public ResponseEntity<String> createQuestion(@RequestParam String category, @RequestParam int numbOfQues,@RequestParam String title)
	{
		return realQuizService.create(category, numbOfQues, title);
	}
	
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return realQuizService.getQuizQuestions(id);
	}
	

}
