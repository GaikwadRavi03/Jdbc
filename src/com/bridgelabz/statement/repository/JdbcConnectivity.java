package com.bridgelabz.statement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectivity {

	static String url = "jdbc:mysql://localhost:3306/CrudDB";
	static String user = "root";
	static String pass = "root";
	static Connection con = null;

	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
