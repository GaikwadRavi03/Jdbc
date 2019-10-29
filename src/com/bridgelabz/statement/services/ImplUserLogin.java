package com.bridgelabz.statement.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.statement.model.Users;
import com.bridgelabz.statement.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class ImplUserLogin implements UserLogin {

	static Connection con = (Connection) JdbcConnectivity.getConnection(); // Method call for DB connection
	static Statement stmt = null;	// Create object of Statement

	/**
	 * Purpose : Insert new user in DataBase.
	 */
	@Override
	public void insertIntoUser(Users user) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO Users VALUES(" + user.getUser_id() + " ,'" + user.getUsername() + "','"
					+ user.getGmail() + "','" + user.getPassword() + "')";

			stmt = con.createStatement(); // Create a statement
			stmt.executeUpdate(query); // Execute the Query
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Purpose : Update the user data from database and stored in database.
	 */
	@SuppressWarnings("resource")
	@Override
	public void updateIntoUser(int id, Users user) {
		// TODO Auto-generated method stub
		try {
			System.out.println("1.name\n2.gmail\n3.password\n4.exit");
			Scanner sc = new Scanner(System.in);
			int ch1 = sc.nextInt();
			switch (ch1) {
			case 1:
				System.out.println("enter new user name");
				String name = sc.next();
				String query = "UPDATE Users SET  username= '" + name + "' WHERE user_id= " + id;
				try {
					stmt = con.createStatement(); // Create a statement
					stmt.executeUpdate(query); // Execute Query
					System.out.println("user name update");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("enter new gmail");
				String gmail = sc.next();
				String query1 = "UPDATE Users SET  gmail= '" + gmail + "' WHERE user_id= " + id;
				try {
					stmt = con.createStatement(); // Create a statement
					stmt.executeUpdate(query1); // Execute Query
					System.out.println("user mail update");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("enter new password");
				String pass = sc.next();
				String query2 = "UPDATE Users SET  password= '" + pass + "' WHERE user_id= " + id;
				try {
					stmt = con.createStatement(); // Create a statement
					stmt.executeUpdate(query2); // Execute Query
					System.out.println("user password update");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 4:
				System.out.println("Exit");
				break;

			default:
				System.out.println("PLease enter valid input");
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid choice");
		}
	}

	/**
	 * Purpose : print the user all data which stored in database.
	 */
	@Override
	public void readFromUser() {
		// TODO Auto-generated method stub
		try {
			String query = "select * from Users";

			stmt = con.createStatement(); // Create a statement
			ResultSet rs = stmt.executeQuery(query); // Execute Query
			while (rs.next()) { // process for Result
				System.out.println("user_id: " + rs.getInt(1) + " username: " + rs.getString(2) + " gmail: "
						+ rs.getString(3) + " password: " + rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Purpose : Delete the user from DataBase.
	 */
	public void deletefromUser(int id) {
		// TODO Auto-generated method stub
		try {
			String query = "delete from Users where user_id=" + id;

			stmt = con.createStatement(); // Create a statement
			stmt.executeUpdate(query); // Execute Query
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
