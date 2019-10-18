package com.bridgelabz.callable.controller;

import java.sql.SQLException;

import com.bridgelabz.callable.repository.JdbcConnectivity;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class BatchProcessingCallable {
	static Connection con = (Connection) JdbcConnectivity.getConnection(); // Method call for DB connection
	static CallableStatement cstmt = null; // Create object of Callable Statement

	public static void main(String[] args) throws SQLException {

		int[] result = executeAll();	// function call to executes all Queries.
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("operation execute");
	}

	
	private static int[] executeAll() throws SQLException {
		cstmt = (CallableStatement) con.prepareCall("call insertUser(?,?,?,?)");
		cstmt.setInt(1, 7);
		cstmt.setString(2, "Dhoni");
		cstmt.setString(3, "msd.com");
		cstmt.setString(4, "msd@123");
		cstmt.addBatch();

		cstmt.setInt(1, 18);
		cstmt.setString(2, "Virat");
		cstmt.setString(3, "wrong.com");
		cstmt.setString(4, "wrong@123");
		cstmt.addBatch();

		return cstmt.executeBatch();
	}

}