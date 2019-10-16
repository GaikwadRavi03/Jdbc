package com.bridgelabz.statement.services;

import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.statement.model.Users;
import com.bridgelabz.statement.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class ImplUserLogin implements UserLogin {

	static Connection con = (Connection) JdbcConnectivity.getConnection();
	static Statement stmt = null;

	@Override
	public void insertIntoUser(Users user) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO Users VALUES(" + user.getUser_id() + "," + user.getUsername() + ","
					+ user.getFullname() + "," + user.getGmail() + "," + user.getPassword() + "')";

			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateIntoUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readFromUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletefromUser() {
		// TODO Auto-generated method stub

	}

}
