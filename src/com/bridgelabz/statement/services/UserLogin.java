package com.bridgelabz.statement.services;

import com.bridgelabz.statement.model.Users;

public interface UserLogin {

	public void insertIntoUser(Users user);

	public void readFromUser();

	void deletefromUser(int id);

	void updateIntoUser(int userid, Users user);
}
