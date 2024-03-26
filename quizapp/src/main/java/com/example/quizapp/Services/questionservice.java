package com.example.quizapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.quizapp.entites.questions;

import com.example.quizapp.repository.questionrepository;

@Service
public class questionservice {
	@Autowired
	questionrepository quizrep;






	public  ResponseEntity<List<questions>> getquestions() {
		try {
			return  new ResponseEntity<>(quizrep.findAll(),HttpStatus.OK) ;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}






	public ResponseEntity<List<questions>>  getquestionbycategory(String category) {
		try {
			return new ResponseEntity<> (quizrep.findBycategory(category),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}






	public ResponseEntity< String> addquestions(questions q) {
		quizrep.save(q);
		try {
			return new ResponseEntity<> ("sucess",HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
		
		
		
		
	}









	

}
