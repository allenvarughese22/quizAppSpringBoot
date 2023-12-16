package com.practice.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.quiz.dao.QuestionDao;
import com.practice.quiz.dao.RealQuizDao;
import com.practice.quiz.model.Question;
import com.practice.quiz.model.QuestionWrapper;
import com.practice.quiz.model.RealQuiz;

@Service
public class RealQuizService {

	
	@Autowired
	RealQuizDao realQuizDao;
	
	@Autowired
	QuestionDao questionDao;

	

	public ResponseEntity<String> create(String category, int numbOfQues, String title) {
		// TODO Auto-generated method stub
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numbOfQues);
		
		RealQuiz realQuiz = new RealQuiz();
		
		realQuiz.setQuestions(questions);
		realQuiz.setTitle(title);
		realQuizDao.save(realQuiz);
		
		return new ResponseEntity<String>("Quiz created", HttpStatus.CREATED);
	}



	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<RealQuiz> realQuiz = realQuizDao.findById(id);
		List<Question> questionfromDb = realQuiz.get().getQuestions();
		
		List<QuestionWrapper> questionForUser  = new ArrayList<QuestionWrapper>();
		for (Question q : questionfromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion_title(), q.getOption1(), 
					q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qw);
			
		}
		return  new ResponseEntity<>(questionForUser, HttpStatus.CREATED);
	}

}
