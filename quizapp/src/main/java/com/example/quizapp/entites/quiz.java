package com.example.quizapp.entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;



import com.example.quizapp.entites.questions;

@Entity
public class quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;
@ManyToMany
private List<questions> ques;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<questions> getQues() {
	return ques;
}

public void setQues(List<questions> ques) {
	
	this.ques = ques;
}





}

