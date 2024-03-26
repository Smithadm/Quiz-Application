package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.entites.quiz;
@Repository
public interface quizrepository extends JpaRepository<quiz, Integer> {
	

}
