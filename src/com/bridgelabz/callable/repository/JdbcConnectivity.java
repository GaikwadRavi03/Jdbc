package com.bridgelabz.callable.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectivity {

	static String url = "jdbc:mysql://localhost:3306/CrudDB?autoReconnect=true&useSSL=false"; // uniform resource
																								// locator
	static String user = "root"; // mysql user id
	static String pass = "root"; // mysql user password
	static Connection con = null;

	public static Connection getConnection() { // connection method
		try {
			con = DriverManager.getConnection(url, user, pass); // Establish the connection
			Class.forName("com.mysql.jdbc.Driver"); // Load & Register Drivers.
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con; // return connection
	}
}