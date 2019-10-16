package com.bridgelabz.statement.services;

import com.bridgelabz.statement.model.Users;

public interface UserLogin {
	public void insertIntoUser(Users user);

	public void updateIntoUser();

	public void readFromUser();

	public void deletefromUser();
}
