package com.bridgelabz.savepoint.services;

import java.sql.SQLException;
import java.sql.Savepoint;

import com.bridgelabz.savepoint.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SavePointTransaction implements savePointInterface {

	static Connection con = (Connection) JdbcConnectivity.getConnection();
	static PreparedStatement pstmt = null;

	/**
	 * Purpose : To Execute query and create save point and again execute some query
	 * and to store till savepoint data rollback.
	 */
	@Override
	public void transcation() throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into Users values(?,?,?,?)";
		pstmt = (PreparedStatement) con.prepareStatement(query);
		con.setAutoCommit(false);

		pstmt.setInt(1, 101);
		pstmt.setString(2, "suraj");
		pstmt.setString(3, "Cogni.com");
		pstmt.setString(4, "Cogni@123");

		pstmt.executeUpdate();
		System.out.println("entry is added");

		// create savePoint here therefore you rollBack the second query
		Savepoint sp = con.setSavepoint();
		pstmt.setInt(1, 102);
		pstmt.setString(2, "pankaj");
		pstmt.setString(3, "capgemimi.com");
		pstmt.setString(4, "pank@123");

		pstmt.executeUpdate();
		con.rollback(sp);	// RollBack .
		con.commit();
	}

}
