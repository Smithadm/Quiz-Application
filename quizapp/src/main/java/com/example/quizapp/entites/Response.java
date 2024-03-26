package com.example.quizapp.entites;

import jakarta.persistence.Entity;


public class Response {
Integer id;
String response;
public Response(Integer id, String response) {
	super();
	this.id = id;
	this.response = response;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getResponse() {
	return response;
}
public void setResponse(String response) {
	this.response = response;
}


}
