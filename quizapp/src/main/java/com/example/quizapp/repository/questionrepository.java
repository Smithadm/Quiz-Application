package com.example.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapp.entites.questions;
@Repository
public interface questionrepository extends JpaRepository<questions, Integer> {


List<questions> findBycategory(String category);

@Query(value="SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ"
		,nativeQuery=true)
List<questions> findrandomquestionbycategory(String category, int numQ);

}
