package com.bridgelabz.statement.controller;

import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.statement.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class BatchProcessingStatement {
	static Connection con = (Connection) JdbcConnectivity.getConnection(); // Method call for DB connection
	static Statement stmt = null; // Create object of Statement

	public static void main(String[] args) throws SQLException {

		int[] result = executeAll();	// function call to executes all Queries.
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("operation execute");
	}

	private static int[] executeAll() throws SQLException {
		stmt = con.createStatement();
		String query = "insert into Users values(10,'Akcent','songspk.com','songs')";
		stmt.addBatch(query);
		String queryInsert = "insert into Users values(20,'john','wwe.com','fight')";
		stmt.addBatch(queryInsert);
		String queryUpdate = "update Users set username='jack' where user_id=20";
		stmt.addBatch(queryUpdate);
		String queryDelete = "delete from Users where user_id=10";
		stmt.addBatch(queryDelete);
		return stmt.executeBatch();
	}

}