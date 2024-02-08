package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.AdminDao;
import com.example.app.domain.Admins;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Override
	public boolean isCorrectIdAndPassword(String userId, String pass) throws Exception {

		Admins admin = dao.selectByLoginId(userId);

		// ログインIDチェック
		if (admin == null) {
			return false;
		}

		// パスワードチェック
		if (!BCrypt.checkpw(pass, admin.getPass())) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isCorrectIdAndPasswordUser(String userId, String pass) throws Exception {
		Admins admin = dao.selectByLoginIdUser(userId);

		// ログインIDチェック
		if (admin == null) {
			return false;
		}

		// パスワードチェック
		if (!BCrypt.checkpw(pass, admin.getPass())) {
			return false;
		}

		return true;
	}

}
