package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Services.Quizsevice;
import com.example.quizapp.entites.Response;
import com.example.quizapp.entites.questions;
import com.example.quizapp.entites.questionwrapper;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	Quizsevice quizservice;
	@PostMapping("create")
	public ResponseEntity<String> createquiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
		return quizservice.createquiz(category,numQ,title) ;
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<questionwrapper>> fetchquestions(@PathVariable int id){
	return quizservice.	fetchquestions(id);
	}
	@PostMapping("score/{id}")
	public ResponseEntity<Integer> findscore(@PathVariable int id,@RequestBody List<Response> response){
		return quizservice.findscore(id,response);
	}

}
