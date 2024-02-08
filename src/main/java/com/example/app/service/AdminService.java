package com.example.app.service;

public interface AdminService {

	 boolean isCorrectIdAndPassword(String userId, String pass) throws Exception;
	 
	 boolean isCorrectIdAndPasswordUser(String userId, String pass) throws Exception;
}
