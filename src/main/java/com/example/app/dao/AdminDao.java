package com.example.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Admins;

@Mapper
public interface AdminDao {

	Admins selectByLoginId(String userId) throws Exception;
	
	Admins selectByLoginIdUser(String userId) throws Exception;
}
