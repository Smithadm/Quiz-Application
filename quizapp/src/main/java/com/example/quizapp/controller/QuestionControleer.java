package com.example.quizapp.controller;

import java.util.List;
import com.example.quizapp.entites.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Services.questionservice;

@RestController
@RequestMapping("questions")
public class QuestionControleer {
	@Autowired
	questionservice quizser;
	
	
	@GetMapping("allquestions")
	public  ResponseEntity< List<questions>> getquestions() {
		return quizser.getquestions();
	}
	@GetMapping("category/{category}")
	
	public ResponseEntity<List<questions>> getquestionbycategory( @PathVariable  String category){
		return quizser.getquestionbycategory(category);
	}
	@PostMapping("add")
	public ResponseEntity<String> addquestions(@RequestBody   questions q) {
		return quizser.addquestions(q);
		
	}
}
