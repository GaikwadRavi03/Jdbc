package com.bridgelabz.prepare.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bridgelabz.prepare.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class BatchProcessingPrepare {

	static Connection con = (Connection) JdbcConnectivity.getConnection(); // Method call for DB connection
	static PreparedStatement pstmt = null; // Create object of Prepare Statement

	public static void main(String[] args) throws SQLException {

		int[] result = executeAll();	// function call to executes all Queries.
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("operation execute");
	}

	private static int[] executeAll() throws SQLException {

		String query = "insert into Users values (?,?,?,?)";

		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, 11);
		pstmt.setString(2, "modi");
		pstmt.setString(3, "bjp.com");
		pstmt.setString(4, "bjp@123");
		pstmt.addBatch();

		pstmt.setInt(1, 21);
		pstmt.setString(2, "rahul");
		pstmt.setString(3, "cong.comm");
		pstmt.setString(4, "cong@123");
		pstmt.addBatch();
		return pstmt.executeBatch();
	}
}