package com.bridgelabz.callable.services;

import java.sql.SQLException;

import com.bridgelabz.callable.model.Users;

public interface UserLogin {

	public int insertIntoUser(Users user) ;

	public void readFromUser();

	int deletefromUser(int id) throws SQLException;

	int updateIntoUser(int userid, Users user);
}
