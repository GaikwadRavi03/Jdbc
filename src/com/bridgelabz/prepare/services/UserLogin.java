package com.bridgelabz.prepare.services;

import java.sql.SQLException;

import com.bridgelabz.prepare.model.Users;

public interface UserLogin {

	public int insertIntoUser(Users user) throws SQLException;

	public void readFromUser();

	int deletefromUser(int id);

	int updateIntoUser(int userid, Users user);

}
