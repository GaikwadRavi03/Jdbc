package com.bridgelabz.login.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bridgelabz.login.model.Users;
import com.bridgelabz.login.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class ImplUserLogin implements UserLogin {

	static Connection con = (Connection) JdbcConnectivity.getConnection(); // Method call for DB connection
	static PreparedStatement pstmt = null; // Create object of PrepareStatement

	/**
	 * Purpose : Insert new User in Database.
	 */
	@Override
	public int insertUser(Users user) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Users VALUES(?,?,?,?)";

		pstmt = con.prepareStatement(query);

		pstmt.setInt(1, user.getUser_id());
		pstmt.setString(2, (user.getUsername()));
		pstmt.setString(3, (user.getGmail()));
		pstmt.setString(4, (user.getPassword()));

		return pstmt.executeUpdate(); // Update all data in database
	}

	/**
	 * Purpose : Find the user in database and check existing.
	 */
	@Override
	public Users checkUser(int user_id, String username) throws SQLException {
		// TODO Auto-generated method stub
		Users user = new Users();
		String query = "select * from Users where user_id=? and username=?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, username);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user.setUser_id(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setGmail(rs.getString(3));
			user.setPassword(rs.getString(4));
		}
		return user;
	}
}