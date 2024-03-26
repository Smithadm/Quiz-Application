package com.example.quizapp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.quizapp.entites.Response;
import com.example.quizapp.entites.questions;
import com.example.quizapp.entites.questionwrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.entites.quiz;
import com.example.quizapp.repository.questionrepository;
import com.example.quizapp.repository.quizrepository;
@Service
public class Quizsevice {
	@Autowired
	quizrepository qr;
	@Autowired
	questionrepository quizrep;
	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		
		
List<questions>	 ques=quizrep.findrandomquestionbycategory(category,numQ);
quiz q=new quiz();
		q.setTitle(title);
	q.setQues(ques);
	qr.save(q);
		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
	}
	public ResponseEntity<List<questionwrapper>> fetchquestions(int id) {
		Optional<quiz> q=qr.findById(id);
	List<questions>	questionfromdb=q.get().getQues();
	List<questionwrapper>  quesf=new ArrayList<>();
	for(questions qq:questionfromdb) {
		questionwrapper qw=new questionwrapper(qq.getId(),qq.getcategory(),qq.getDifficultylevel(),qq.getOption1(),qq.getOption2(),qq.getOption3(),qq.getOption4(),qq.getQuestion_title());
		quesf.add(qw);
	}
		return new ResponseEntity<>( quesf,HttpStatus.OK);
	}
	public ResponseEntity<Integer> findscore(int id, List<Response> response) {
		Optional<quiz> q=qr.findById(id);
		List<questions>	qfrmdb=q.get().getQues();
		int i=0;//first question
		int index=0;
		for(Response r:response) {
			if(r.getResponse().equals(qfrmdb.get(i).getRight_answer())) {
				index++;
			}
			i++;
		}
		return new ResponseEntity<>( index,HttpStatus.OK);
	}
}

