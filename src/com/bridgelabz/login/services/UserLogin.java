package com.bridgelabz.login.services;

import java.sql.SQLException;

import com.bridgelabz.login.model.Users;

public interface UserLogin {

	public Users checkUser(int user_id, String username) throws SQLException;

	public int insertUser(Users user) throws SQLException;
}
